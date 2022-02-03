import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;
public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void getLinksTest() throws IOException{
        Path fileName = Path.of("test-file.md");
        String contents = Files.readString(fileName);

        assertEquals(List.of("https://something.com", "some-page.html"), MarkdownParse.getLinks(contents));
    }

    @Test
    public void getLinksTest2() throws IOException{
        Path fileName = Path.of("test-file2.md");
        String contents = Files.readString(fileName);

        assertEquals(List.of("https://something.com", "some-page.html"), MarkdownParse.getLinks(contents));
    }

    @Test
    public void getLinksTest3() throws IOException{
        Path fileName = Path.of("test-file3.md");
        String contents = Files.readString(fileName);

        assertEquals(List.of(), MarkdownParse.getLinks(contents));
    }

    @Test
    public void getLinksTest4() throws IOException{
        Path fileName = Path.of("test-file4.md");
        String contents = Files.readString(fileName);

        assertEquals(List.of(), MarkdownParse.getLinks(contents));
    }

    @Test
    public void getLinksTest7() throws IOException{
        Path fileName = Path.of("test-file7.md");
        String contents = Files.readString(fileName);

        assertEquals(List.of(), MarkdownParse.getLinks(contents));
    }

    @Test
    public void getLinksTest8() throws IOException{
        Path fileName = Path.of("test-file8.md");
        String contents = Files.readString(fileName);

        assertEquals(List.of("a link on the first line"), MarkdownParse.getLinks(contents));
    }


}