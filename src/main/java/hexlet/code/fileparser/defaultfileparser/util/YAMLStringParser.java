package hexlet.code.fileparser.defaultfileparser.util;

import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

/**
 * Парсер для YAML.
 * <p>
 * {@link hexlet.code.fileparser.FileType#YAML}
 */
public final class YAMLStringParser implements StringParser {

    @Override
    public Map<String, Object> parse(@NotNull final String str) throws StringParserException {
        return StringParserHelper.parseWithObjectMapper(str, new YAMLFactory());
    }

}
