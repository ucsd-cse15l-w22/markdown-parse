import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

// javac -cp ".;lib/\*" MarkdownParseTest.java
// java -cp ".;lib/\*" org.junit.runner.JUnitCore MarkdownParseTest

public class MarkdownParseTest {
    
    private static ArrayList<String> getLinks(String filename) throws IOException {
        return MarkdownParse.getLinks(Files.readString(Path.of(filename)));
    }
    
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testGetLink() throws IOException {
        ArrayList<String> actual = getLinks("test-file.md");
        List<String> expected = List.of("https://something.com", "some-page.html");
        assertEquals(expected, actual);
    }

    @Test
    public void testGetLinkTwo() throws IOException {
        ArrayList<String> actual = getLinks("breaking-test-file.md");
        List<String> expected = List.of("https://www.google.com");
        assertEquals(expected, actual);
    }
}