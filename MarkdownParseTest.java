import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }
    @Test
    public void parseTest1() throws IOException {
        List<String> expectedList = List.of("https://something.com", "some-page.html");
        Path fileName = Path.of("test-file.md");
	    String contents = Files.readString(fileName);

        assertEquals("Test for test-file1 parse",expectedList,  MarkdownParse.getLinks(contents));
        //System.out.println(MarkdownParse.getLinks(contents).toString());
    }
    
    @Test
    public void parseTest2() throws IOException {
        List<String> expectedList = List.of();
        Path fileName = Path.of("test-file2.md");
	    String contents = Files.readString(fileName);
        assertEquals("Test for no test-file2 parse",expectedList,  MarkdownParse.getLinks(contents));
    }
    
    @Test
    public void parseTest3() throws IOException {
        List<String> expectedList = List.of();
        Path fileName = Path.of("test-file3.md");
	    String contents = Files.readString(fileName);
        assertEquals("Test for no test-file2 parse",expectedList,  MarkdownParse.getLinks(contents));
    }
    
}