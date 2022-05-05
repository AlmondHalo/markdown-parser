Markdownparse.class : Markdownparse.test
	javac Markdownparse.java
MarkdownparseTest.class : MarkdownparseTest.java Markdownparse.class
	javac -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar MarkdownParseTest.java
run : MarkdownparseTest.class
	java MarkdownparseTest.java