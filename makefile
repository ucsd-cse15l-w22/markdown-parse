test: MarkdownParse.class MarkdownParseTest.class
	java -cp .:lib/* org.junit.runner.JUnitCore MarkdownParseTest

MarkdownParse.class: MarkdownParse.java
	javac -cp .:lib/* MarkdownParse.java

MarkdownParseTest.class: MarkdownParseTest.java
	javac -cp .:lib/* MarkdownParseTest.java
