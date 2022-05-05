Markdownparse.class : Markdownparse.java
	javac Markdownparse.java
MarkdownparseTest.class : MarkdownparseTest.java Markdownparse.class
	javac -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar MarkdownParseTest.java
run : MarkdownparseTest.class
	java -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore MarkdownParseTest