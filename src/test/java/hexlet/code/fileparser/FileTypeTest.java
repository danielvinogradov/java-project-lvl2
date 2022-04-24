package hexlet.code.fileparser;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileTypeTest {

    @Test
    void fromPathTest() {
        Path jsonPath = Paths.get("/some/path/file.json");
        Path yamlPath = Paths.get("/some/path/file.yml");
        Path multipleDotsPath = Paths.get("/some/path/file.temp.json");

        assertEquals(FileType.JSON, FileType.fromPath(jsonPath));
        assertEquals(FileType.YAML, FileType.fromPath(yamlPath));
        assertEquals(FileType.JSON, FileType.fromPath(multipleDotsPath));
    }

}
