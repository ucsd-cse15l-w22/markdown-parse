import static org.junit.Assert.*;

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
  /*
    @Test
    public void links() throws IOException {

		Path fileName = Path.of("C:\\Users\\heter\\Documents\\GitHub\\markdown-parse, test-file.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        List<String> output = List.of("[]");
        assertEquals(output, links);
    }
    */
}