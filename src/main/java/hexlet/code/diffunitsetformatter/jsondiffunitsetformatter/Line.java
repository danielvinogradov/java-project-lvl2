package hexlet.code.diffunitsetformatter.jsondiffunitsetformatter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.jetbrains.annotations.NotNull;

final class Line {

    private final OperationType operationType;

    private final String key;

    private final Object value;

    Line(@NotNull final OperationType newOperationType, @NotNull final String newKey, @NotNull final Object newValue) {
        this.operationType = newOperationType;
        this.key = newKey;
        this.value = newValue;
    }

    @Override
    public String toString() {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = null;
        try {
            json = ow.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return String.format("  %s \"%s\": %s", operationType.getSign(), key, json);
    }

}
