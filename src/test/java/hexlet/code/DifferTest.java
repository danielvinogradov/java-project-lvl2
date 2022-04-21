package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class DifferTest {
    @Test
    public void generate_test() throws IOException {
        String actual = Differ.generate("./src/test/resources/file1.json", "./src/test/resources/file2.json");
        String expected = "{\n" +
                "  - follow: false\n" +
                "    host: hexlet.io\n" +
                "  - proxy: 123.234.53.22\n" +
                "  - timeout: 50\n" +
                "  + timeout: 20\n" +
                "  + verbose: true\n" +
                "}";

        assertEquals(expected, actual);
    }
}
