package hexlet.code.fileparser.defaultfileparser.util;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

final class StringParserHelper {

    private StringParserHelper() {
    }

    static Map<String, Object> parseWithObjectMapper(final String str) throws StringParserException {
        return parseWithObjectMapper(str, null);
    }

    static Map<String, Object> parseWithObjectMapper(@NotNull final String str, final JsonFactory mapperParam)
            throws StringParserException {
        ObjectMapper objectMapper;

        if (mapperParam != null) {
            objectMapper = new ObjectMapper(mapperParam);
        } else {
            objectMapper = new ObjectMapper();
        }

        try {
            return objectMapper.readValue(str, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            throw new StringParserException();
        }
    }

}
