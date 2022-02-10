test: MarkdownParse.class
	java MarkdownParse $1

MarkdownParse.class : MarkdownParse.java
	javac MarkdownParse.java