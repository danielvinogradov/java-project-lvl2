package hexlet.code.fileparser;

import hexlet.code.fileparser.defaultfileparser.util.StringParserException;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

/**
 * Интерфейс парсера.
 * <p>
 * В приложении имеет единственную реализацию {@link hexlet.code.fileparser.defaultfileparser.DefaultFileParser}.
 */
public interface FileParser {

    /**
     * Парсит файл.
     *
     * @param path Путь до файла.
     * @return Мапа, где ключ – это ключ в json/yaml/др, а значение – это значение соответствующего
     * типа (Boolean, String, ArrayList и др.).
     * @throws IOException           Ошибка при чтении файла.
     * @throws StringParserException Ошибка при обработке содержимого файла.
     */
    Map<String, Object> parse(@NotNull Path path) throws IOException, StringParserException;

}
