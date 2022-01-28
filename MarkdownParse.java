import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {
    public static ArrayList<String> getLinks(String[] markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        int currentIndex = 0;
        for (String line: markdown) {
            currentIndex = 0;
            if (line.indexOf(")") == -1) {
                continue;
            }
            int nextOpenBracket = line.indexOf("[", currentIndex);
            int nextCloseBracket = line.indexOf("]", nextOpenBracket);

            int openParen = line.indexOf("(", nextCloseBracket);
            int closeParen = line.indexOf(")", openParen);
            
            toReturn.add(line.substring(openParen + 1, closeParen));
            currentIndex = closeParen + 1;
        }
        return toReturn;
    }
    public static void main(String[] args) throws IOException {
		String regFile = Files.readString(Path.of(args[0]));
        String[] regLines = regFile.split("\n");
        ArrayList<String> links = getLinks(regLines);
        System.out.println(links);
        
    }
}
