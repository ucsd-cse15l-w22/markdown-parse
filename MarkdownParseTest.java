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
        Path fileName = Path.of("/Users/oshima-alex/Documents/GitHub/markdown-parse/test-file.md");
        String contents = Files.readString(fileName);

        assertEquals(List.of("https://something.com", "some-page.html"), MarkdownParse.getLinks(contents));
    }

    @Test
    public void getLinksTest2() throws IOException{
        Path fileName = Path.of("/Users/oshima-alex/Documents/GitHub/markdown-parse/bug-maker-1.md");
        String contents = Files.readString(fileName);

        assertEquals(List.of("www.link.com/dsajlfldkjsajklf"), MarkdownParse.getLinks(contents));
    }
/*
    @Test
    public void getLinksTest3() throws IOException{
        Path fileName = Path.of("/Users/oshima-alex/Documents/GitHub/markdown-parse/bug-maker-2.md");
        String contents = Files.readString(fileName);

        assertEquals(List.of("www.link.com/)dsajlfldkjsajklf"), MarkdownParse.getLinks(contents));
    }
    */
}