import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then take up to
        // the next )
        int currentIndex = 0;
        int lastClosedParen = markdown.lastIndexOf(")");
        while(currentIndex < markdown.length()) {
            int nextOpenBracket = markdown.indexOf("[", currentIndex);

            boolean isImage = false;

            if (markdown.indexOf("!", nextOpenBracket-1) == nextOpenBracket - 1) isImage = true;
            

            if (nextOpenBracket == 0) isImage = false;

            int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
            int openParen = markdown.indexOf("(", currentIndex);
            int closeParen = markdown.indexOf(")", openParen);

            if(nextOpenBracket == -1 || nextCloseBracket == -1 || openParen == -1 || closeParen == -1) {
		        break;
	        }

            if (openParen - nextCloseBracket > 2) {
                currentIndex = markdown.indexOf("[", currentIndex + 1);

                if (currentIndex == lastClosedParen) {
                    break;
                } else if (currentIndex < 0) {
                    break;
                }
                continue;
            }

            

            if(markdown.substring(nextOpenBracket-1, nextOpenBracket).equals("!")) {
                currentIndex = closeParen + 1;
                continue;
            }

            if (!isImage) toReturn.add(markdown.substring(openParen + 1, closeParen));
            if (closeParen > currentIndex){
                currentIndex = closeParen + 1;
            }else {
                break;
            }
        }
        return toReturn;
    }
    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String contents = Files.readString(fileName);
        ArrayList<String> links = getLinks(contents);
        System.out.println(links);
    }
}
