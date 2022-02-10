// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then take up to
        // the next )

        //Use boolean to determine if formatting is correct
        //Allow program to continue running but don't add link
        boolean goodFormat = true;

        int currentIndex = 0;
        while(currentIndex < markdown.length()) {

            //Find next "["
            int nextOpenBracket = markdown.indexOf("[", currentIndex);
            if(nextOpenBracket == -1){
                goodFormat = false;
                break;
            }

            //Find next "]"
            int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
            if(nextCloseBracket == -1){
                goodFormat = false;
                break;
            }

            //Find next "("
            int openParen = markdown.indexOf("(", nextCloseBracket);
            if(openParen == -1){
                goodFormat = false;
                break;
            }

            //Find next ")"
            int closeParen = markdown.indexOf(")", openParen);
            if(closeParen == -1){
                goodFormat = false;
                break;
            }

            if(goodFormat){
                toReturn.add(markdown.substring(openParen + 1, closeParen));
            }
            currentIndex = closeParen + 1;
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