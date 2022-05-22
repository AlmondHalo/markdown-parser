
import static org.junit.Assert.*;
import org.junit.*;

import java.beans.Transient;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1+1);
    }

    @Test
    public void MarkdownParse() throws IOException{
        ArrayList<String> returned;
        ArrayList<String> something = new ArrayList<>();
        something.add("https://something.com");
        something.add("some-thing.html");
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        returned = MarkdownParse.getLinks(content);
        assertEquals(returned, something);
    }

    @Test
    public void Snip1() throws IOException{
        String contents = Files.readString(Path.of("testSnip1.md"));
        // Path fileName = Path.of("testSnip1.md");
        // String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        ArrayList<String> correctOutput = new ArrayList<>();
        correctOutput.add("`google.com");
        correctOutput.add("google.com");
        correctOutput.add("ucsd.edu");
        assertEquals(correctOutput, links);
    }

    @Test
    public void Snip2() throws IOException{
        Path fileName = Path.of("testSnip2.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        ArrayList<String> correctOutput = new ArrayList<>();
        correctOutput.add("a.com");
        correctOutput.add("a.com(())");
        correctOutput.add("example.com");
        assertEquals(correctOutput, links);
    }

    @Test
    public void Snip3() throws IOException{
        Path fileName = Path.of("testSnip3.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        ArrayList<String> correctOutput = new ArrayList<>();
        correctOutput.add("https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule");
        assertEquals(correctOutput, links);
    }
}
