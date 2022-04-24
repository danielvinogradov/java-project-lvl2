package hexlet.code;

import hexlet.code.diffunitsetformatter.FormatType;
import hexlet.code.fileparser.defaultfileparser.util.StringParserException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class DifferTest {


    /**
     * Тестирует работу с 2 json файлами.
     * <p>
     * Формат вывода {@link FormatType#STYLISH}.
     */
    @Test
    void generate_json_stylish_test() throws IOException, StringParserException {
        String actual = Differ.generate(TestHelper.FIXTURES_JSON_DIR + "file1.json",
                TestHelper.FIXTURES_JSON_DIR + "file2.json");
        String expected = "{\n" +
                "    chars1: [a, b, c]\n" +
                "  - chars2: [d, e, f]\n" +
                "  + chars2: false\n" +
                "  - checked: false\n" +
                "  + checked: true\n" +
                "  - default: null\n" +
                "  + default: [value1, value2]\n" +
                "  - id: 45\n" +
                "  + id: null\n" +
                "  - key1: value1\n" +
                "  + key2: value2\n" +
                "    numbers1: [1, 2, 3, 4]\n" +
                "  - numbers2: [2, 3, 4, 5]\n" +
                "  + numbers2: [22, 33, 44, 55]\n" +
                "  - numbers3: [3, 4, 5]\n" +
                "  + numbers4: [4, 5, 6]\n" +
                "  + obj1: {nestedKey=value, isNested=true}\n" +
                "  - setting1: Some value\n" +
                "  + setting1: Another value\n" +
                "  - setting2: 200\n" +
                "  + setting2: 300\n" +
                "  - setting3: true\n" +
                "  + setting3: none\n" +
                "}";

        assertEquals(expected, actual);
    }

    /**
     * Тестирует работу с 2 json файлами.
     * <p>
     * Формат вывода {@link FormatType#PLAIN}.
     */
    @Test
    void generate_json_plain_test() throws IOException, StringParserException {
        String actual = Differ.generate(TestHelper.FIXTURES_JSON_DIR + "file1.json",
                TestHelper.FIXTURES_JSON_DIR + "file2.json", FormatType.PLAIN);
        String expected = "Property 'chars2' was updated. From [complex value] to false\n" +
                "Property 'checked' was updated. From false to true\n" +
                "Property 'default' was updated. From null to [complex value]\n" +
                "Property 'id' was updated. From 45 to null\n" +
                "Property 'key1' was removed\n" +
                "Property 'key2' was added with value: 'value2'\n" +
                "Property 'numbers2' was updated. From [complex value] to [complex value]\n" +
                "Property 'numbers3' was removed\n" +
                "Property 'numbers4' was added with value: [complex value]\n" +
                "Property 'obj1' was added with value: [complex value]\n" +
                "Property 'setting1' was updated. From 'Some value' to 'Another value'\n" +
                "Property 'setting2' was updated. From 200 to 300\n" +
                "Property 'setting3' was updated. From true to 'none'";

        assertEquals(expected, actual);
    }

    /**
     * Тестирует работу с 2 yaml файлами.
     * <p>
     * Формат вывода {@link FormatType#STYLISH}.
     */
    @Test
    void generate_yaml_stylish_test() throws IOException, StringParserException {
        String actual = Differ.generate(TestHelper.FIXTURES_YAML_DIR + "file1.yaml",
                TestHelper.FIXTURES_YAML_DIR + "file2.yaml");
        String expected = "{\n" +
                "  + applications: [Figma, Adobe Photoshop]\n" +
                "  - education: 4 GCSEs\n" +
                "3 A-Levels\n" +
                "BSc in the Internet of Things\n" +
                "\n" +
                "  + education: BSc in Web Design\n" +
                "Some Design Bootcamp\n" +
                "\n" +
                "    employed: true\n" +
                "  - foods: [Apple, Orange, Strawberry, Mango]\n" +
                "  + foods: [Apple, Strawberry, Milk]\n" +
                "  - job: Developer\n" +
                "  + job: Designer\n" +
                "  - languages: {perl=Elite, python=Elite, pascal=Lame}\n" +
                "  - name: Martin D'vloper\n" +
                "  + name: Mikey D'vloper\n" +
                "  - skill: Elite\n" +
                "  + skill: Mediocre\n" +
                "}";

        assertEquals(expected, actual);
    }

    /**
     * Тестирует работу с 2 json файлами.
     * <p>
     * Формат вывода {@link FormatType#PLAIN}.
     */
    @Test
    void generate_yaml_plain_test() throws IOException, StringParserException {
        String actual = Differ.generate(TestHelper.FIXTURES_YAML_DIR + "file1.yaml",
                TestHelper.FIXTURES_YAML_DIR + "file2.yaml", FormatType.PLAIN);
        String expected = "Property 'applications' was added with value: [complex value]\n" +
                "Property 'education' was updated. From '4 GCSEs\n" +
                "3 A-Levels\n" +
                "BSc in the Internet of Things\n" +
                "' to 'BSc in Web Design\n" +
                "Some Design Bootcamp\n" +
                "'\n" +
                "Property 'foods' was updated. From [complex value] to [complex value]\n" +
                "Property 'job' was updated. From 'Developer' to 'Designer'\n" +
                "Property 'languages' was removed\n" +
                "Property 'name' was updated. From 'Martin D'vloper' to 'Mikey D'vloper'\n" +
                "Property 'skill' was updated. From 'Elite' to 'Mediocre'";

        assertEquals(expected, actual);
    }

}
