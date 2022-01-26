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
        int currentIndex = 0;
        System.out.println(currentIndex);
        boolean isImage = false;
        while(currentIndex < markdown.length()) {
            isImage = false; 
            if(markdown.indexOf("![", currentIndex)!=-1) isImage = true;
            int nextOpenBracket = markdown.indexOf("[", currentIndex);
            int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
            //break for joetest7.md
            if(nextCloseBracket==-1)break;
            //break for joetest8.md
            if(nextOpenBracket==nextCloseBracket-1)break;
            int openParen = markdown.indexOf("(", nextCloseBracket);
            //break for joetest5.md
            if(nextCloseBracket!=openParen-1)break;
            int closeParen = markdown.indexOf(")", openParen);
            currentIndex = closeParen + 1;
            if(closeParen==-1) break;
            if(markdown.indexOf("[", currentIndex)==-1){
                currentIndex = markdown.length();
            }
            if(!isImage){
             toReturn.add(markdown.substring(openParen + 1, closeParen));
            }
            System.out.println(currentIndex);
            System.out.println(":)");
            
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