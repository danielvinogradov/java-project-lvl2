package hexlet.code.fileparser.defaultfileparser.util;

import org.jetbrains.annotations.NotNull;

import java.util.Map;

/**
 * Парсер для JSON.
 * <p>
 * {@link hexlet.code.fileparser.FileType#JSON}
 */
public final class JSONStringParser implements StringParser {

    @Override
    public Map<String, Object> parse(@NotNull final String str) throws StringParserException {
        return StringParserHelper.parseWithObjectMapper(str);
    }

}
