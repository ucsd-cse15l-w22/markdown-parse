import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import org.junit.*;

public class MarkdownParseTest {
    // Setting up a new test case
    @Test
    public void addition() {
        // Asserting that the left of the comma is equal to the right
        assertEquals(2, 1 + 1);
    }
    @Test
    public void test1() throws IOException{
        Path fileName = Path.of("test-file.md");
        System.out.println(fileName.toString());
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);   
        List<String> expected = List.of(" ");
        assertEquals(expected, links);
    }
}