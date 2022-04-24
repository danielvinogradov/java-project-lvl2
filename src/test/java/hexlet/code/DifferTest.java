package hexlet.code;

import hexlet.code.diffunitsetformatter.FormatType;
import hexlet.code.fileparser.defaultfileparser.util.StringParserException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {


    /**
     * Тестирует работу с 2 json файлами.
     * <p>
     * Формат вывода {@link FormatType#STYLISH}.
     */
    @Test
    void generateJsonStylishTest() throws IOException, StringParserException {
        String actual = Differ.generate(TestHelper.FIXTURES_JSON_DIR + "file1.json",
                TestHelper.FIXTURES_JSON_DIR + "file2.json");
        String expected = new StringBuilder()
                .append("{\n")
                .append("    chars1: [a, b, c]\n")
                .append("  - chars2: [d, e, f]\n")
                .append("  + chars2: false\n")
                .append("  - checked: false\n")
                .append("  + checked: true\n")
                .append("  - default: null\n")
                .append("  + default: [value1, value2]\n")
                .append("  - id: 45\n")
                .append("  + id: null\n")
                .append("  - key1: value1\n")
                .append("  + key2: value2\n")
                .append("    numbers1: [1, 2, 3, 4]\n")
                .append("  - numbers2: [2, 3, 4, 5]\n")
                .append("  + numbers2: [22, 33, 44, 55]\n")
                .append("  - numbers3: [3, 4, 5]\n")
                .append("  + numbers4: [4, 5, 6]\n")
                .append("  + obj1: {nestedKey=value, isNested=true}\n")
                .append("  - setting1: Some value\n")
                .append("  + setting1: Another value\n")
                .append("  - setting2: 200\n")
                .append("  + setting2: 300\n")
                .append("  - setting3: true\n")
                .append("  + setting3: none\n")
                .append("}")
                .toString();

        assertEquals(expected, actual);
    }

    /**
     * Тестирует работу с 2 json файлами.
     * <p>
     * Формат вывода {@link FormatType#PLAIN}.
     */
    @Test
    void generateJsonPlainTest() throws IOException, StringParserException {
        String actual = Differ.generate(TestHelper.FIXTURES_JSON_DIR + "file1.json",
                TestHelper.FIXTURES_JSON_DIR + "file2.json", FormatType.PLAIN);
        String expected = new StringBuilder()
                .append("Property 'chars2' was updated. From [complex value] to false\n")
                .append("Property 'checked' was updated. From false to true\n")
                .append("Property 'default' was updated. From null to [complex value]\n")
                .append("Property 'id' was updated. From 45 to null\n")
                .append("Property 'key1' was removed\n")
                .append("Property 'key2' was added with value: 'value2'\n")
                .append("Property 'numbers2' was updated. From [complex value] to [complex value]\n")
                .append("Property 'numbers3' was removed\n")
                .append("Property 'numbers4' was added with value: [complex value]\n")
                .append("Property 'obj1' was added with value: [complex value]\n")
                .append("Property 'setting1' was updated. From 'Some value' to 'Another value'\n")
                .append("Property 'setting2' was updated. From 200 to 300\n")
                .append("Property 'setting3' was updated. From true to 'none'")
                .toString();

        assertEquals(expected, actual);
    }

    /**
     * Тестирует работу с 2 yaml файлами.
     * <p>
     * Формат вывода {@link FormatType#STYLISH}.
     */
    @Test
    void generateYamlStylishTest() throws IOException, StringParserException {
        String actual = Differ.generate(TestHelper.FIXTURES_YAML_DIR + "file1.yml",
                TestHelper.FIXTURES_YAML_DIR + "file2.yml");
        String expected = new StringBuilder()
                .append("{\n")
                .append("  + applications: [Figma, Adobe Photoshop]\n")
                .append("  - education: 4 GCSEs\n")
                .append("3 A-Levels\n")
                .append("BSc in the Internet of Things\n")
                .append("\n")
                .append("  + education: BSc in Web Design\n")
                .append("Some Design Bootcamp\n")
                .append("\n")
                .append("    employed: true\n")
                .append("  - foods: [Apple, Orange, Strawberry, Mango]\n")
                .append("  + foods: [Apple, Strawberry, Milk]\n")
                .append("  - job: Developer\n")
                .append("  + job: Designer\n")
                .append("  - languages: {perl=Elite, python=Elite, pascal=Lame}\n")
                .append("  - name: Martin D'vloper\n")
                .append("  + name: Mikey D'vloper\n")
                .append("  - skill: Elite\n")
                .append("  + skill: Mediocre\n")
                .append("}")
                .toString();

        assertEquals(expected, actual);
    }

    /**
     * Тестирует работу с 2 json файлами.
     * <p>
     * Формат вывода {@link FormatType#PLAIN}.
     */
    @Test
    void generateYamlPlainTest() throws IOException, StringParserException {
        String actual = Differ.generate(TestHelper.FIXTURES_YAML_DIR + "file1.yml",
                TestHelper.FIXTURES_YAML_DIR + "file2.yml", FormatType.PLAIN);
        String expected = new StringBuilder()
                .append("Property 'applications' was added with value: [complex value]\n")
                .append("Property 'education' was updated. From '4 GCSEs\n")
                .append("3 A-Levels\n")
                .append("BSc in the Internet of Things\n")
                .append("' to 'BSc in Web Design\n")
                .append("Some Design Bootcamp\n")
                .append("'\n")
                .append("Property 'foods' was updated. From [complex value] to [complex value]\n")
                .append("Property 'job' was updated. From 'Developer' to 'Designer'\n")
                .append("Property 'languages' was removed\n")
                .append("Property 'name' was updated. From 'Martin D'vloper' to 'Mikey D'vloper'\n")
                .append("Property 'skill' was updated. From 'Elite' to 'Mediocre'")
                .toString();

        assertEquals(expected, actual);
    }

}
