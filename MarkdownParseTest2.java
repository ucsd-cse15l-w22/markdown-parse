import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MarkdownParseTest2 {
    
    @Test
    public void parseTest1() throws IOException {
        List<String> expectedList = List.of("`google.com", "google.com", "ucsd.edu");
        Path fileName = Path.of("labtest1.md");
	    String contents = Files.readString(fileName);

        assertEquals("Test for labtest1.md parse",expectedList,  MarkdownParse.getLinks(contents));
    }
    
    
    @Test
    public void parseTest2() throws IOException {
        List<String> expectedList = List.of("a.com(())", "example.com");
        Path fileName = Path.of("labtest2.md");
	    String contents = Files.readString(fileName);

        assertEquals("Test for labtest2.md parse",expectedList,  MarkdownParse.getLinks(contents));
    }
    
    @Test
    public void parseTest3() throws IOException {
        List<String> expectedList = List.of("https://ucsd-cse15l-w22.github.io/");
        Path fileName = Path.of("labtest3.md");
	    String contents = Files.readString(fileName);

        assertEquals("Test for labtest3.md parse",expectedList,  MarkdownParse.getLinks(contents));
    }
    
}