/** javac -cp ".;lib\junit-4.13.2.jar;lib\hamcrest-core-1.3.jar" MarkdownParseTest.java
 *  java -cp ".;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore MarkdownParseTest
 */

import static org.junit.Assert.*;
import org.junit.*;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(4, 1 + 3);
    }
}