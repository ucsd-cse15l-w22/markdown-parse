import static org.junit.Assert.*;
import org.junit.*;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }
    @Test
    public void cool1Test() throws IOException {
        List<String> cool = List.of("https://something.com", "some-page.html");
        Path fileName = Path.of("test-file.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals(cool, links);
        
    }
    @Test
    public void cool4Test() throws IOException {
        List<String> cool = List.of("https://www.ecosia.org/images?q=jesus");
        Path fileName = Path.of("test4.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals(cool, links);
        
    }
    @Test
    public void cool3Test() throws IOException {
        List<String> cool = List.of();
        Path fileName = Path.of("test3.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals(cool, links);
        
    }
    @Test
    public void cool2Test() throws IOException {
        List<String> cool = List.of("https://something.com", "some-page.html");
        Path fileName = Path.of("yourmom.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals(cool, links);
        
    }
}