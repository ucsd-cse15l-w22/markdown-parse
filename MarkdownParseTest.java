import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.*;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testGetlink() {
        List<String> expected = List.of("https://something.com", "some-page.html", "");
        try {
            assertEquals(expected, MarkdownParse.getLinks(Files.readString(Path.of("test-file.md"))));
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testGetlink1() {
        List<String> expected = List.of("https://www.nelink.com", "");
        try {
            assertEquals(expected, MarkdownParse.getLinks(Files.readString(Path.of("new-test-file.md"))));
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testGetlink2() {
        List<String> expected = List.of("https://github.com/mariawang2002826/markdown-parse");
        try {
            assertEquals(expected, MarkdownParse.getLinks(Files.readString(Path.of("test-file-3.md"))));
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testGetlink3() {
        List<String> expected = List.of("https://ucsd-cse15l-w22.github.io/");
        try {
            assertEquals(expected, MarkdownParse.getLinks(Files.readString(Path.of("test-file-4.md"))));
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }            

    }
}