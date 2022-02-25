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
    public void testSnippet1() {
        ArrayList<String> actual = MarkdownParse.getLinks(
            "`[a link`](url.com)\n\n"+
            "[another link](`google.com)`\n\n"+
            "[`cod[e`](google.com)\n\n"+
            "[`code]`](ucsd.edu)"
        );
        List<String> expected = List.of("`google.com", "google.com", "ucsd.edu");
        assertEquals(expected, actual);
    }

    @Test
    public void testSnippet2() {
        ArrayList<String> actual = MarkdownParse.getLinks(
            "[a [nested link](a.com)](b.com)\n\n"+
            "[a nested parenthesized url](a.com(()))\n\n"+
            "[some escaped \\[ brackets \\]](example.com)"
        );
        List<String> expected = List.of("a.com", "a.com(())", "example.com");
        assertEquals(expected, actual);
    }

    @Test
    public void testSnippet3() {
        ArrayList<String> actual = MarkdownParse.getLinks(
            "[this title text is really long and takes up more than \n"+
            "one line\n\n"+
            "and has some line breaks](\n"+
            "    https://www.twitter.com\n"+
            ")\n\n"+
            "[this title text is really long and takes up more than \n"+
            "one line](\n"+
            "    https://ucsd-cse15l-w22.github.io/\n"+
            ")\n\n\n"+
            "[this link doesn't have a closing parenthesis](github.com\n\n"+
            "And there's still some more text after that.\n\n"+
            "[this link doesn't have a closing parenthesis for a while](https://cse.ucsd.edu/\n\n\n\n"+
            ")\n\n"+
            "And then there's more text"
        );
        List<String> expected = List.of("https://ucsd-cse15l-w22.github.io/");
        assertEquals(expected, actual);
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