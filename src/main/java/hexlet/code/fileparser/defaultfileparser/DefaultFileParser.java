package hexlet.code.fileparser.defaultfileparser;

import hexlet.code.fileparser.FileType;
import hexlet.code.fileparser.FileParser;
import hexlet.code.fileparser.defaultfileparser.util.JSONStringParser;
import hexlet.code.fileparser.defaultfileparser.util.StringParser;
import hexlet.code.fileparser.defaultfileparser.util.StringParserException;
import hexlet.code.fileparser.defaultfileparser.util.YAMLStringParser;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

/**
 * Дефолтный синхронный парсер.
 */
public final class DefaultFileParser implements FileParser {

    @Override
    public Map<String, Object> parse(@NotNull final Path path) throws IOException, StringParserException {
        final FileType fileType = FileType.fromPath(path);
        StringParser parser;

        if (fileType == null) {
            throw new UnsupportedOperationException("Формат файла не поддерживается.");
        }

        switch (fileType) {
            case JSON:
                parser = new JSONStringParser();
                break;
            case YAML:
                parser = new YAMLStringParser();
                break;
            default:
                throw new UnsupportedOperationException("Формат файла не поддерживается.");
        }

        final String rawData = Files.readString(path);

        return parser.parse(rawData);
    }

}
