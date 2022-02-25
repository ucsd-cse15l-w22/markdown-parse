test: MarkdownParseTest.class MarkdownParse.class
	java -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore MarkdownParseTest

MarkdownParseTest.class: MarkdownParseTest.java MarkdownParse.class
	javac -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar MarkdownParseTest.java

MarkdownParse.class : MarkdownParse.java
	javac MarkdownParse.java



test2: MarkdownParseTest2.class MarkdownParse2.class
	java -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore MarkdownParseTest2

MarkdownParseTest2.class: MarkdownParseTest2.java MarkdownParse.class
	javac -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar MarkdownParseTest2.java

MarkdownParse.class : MarkdownParse.java
	javac MarkdownParse.java