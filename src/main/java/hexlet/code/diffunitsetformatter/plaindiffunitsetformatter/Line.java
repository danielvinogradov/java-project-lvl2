package hexlet.code.diffunitsetformatter.plaindiffunitsetformatter;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

final class Line {

    public static final String COMPLEX_VALUE_PLACEHOLDER = "[complex value]";

    private final OperationType operationType;

    private final String key;

    private final Object value;

    private final Object previousValue;

    Line(@NotNull final OperationType newOperationType,
                @NotNull final String newKey,
                @NotNull final Object newValue,
                @NotNull final Object newPreviousValue) {
        this.operationType = newOperationType;
        this.key = newKey;
        this.value = newValue;
        this.previousValue = newPreviousValue;
    }

    public String getKey() {
        return key;
    }

    public Object getValue() {
        if (value instanceof String) {
            return String.format("'%s'", value);
        }

        if (value instanceof List || value instanceof Map) {
            return COMPLEX_VALUE_PLACEHOLDER;
        }

        return value;
    }

    public Object getPreviousValue() {
        if (previousValue instanceof String) {
            return String.format("'%s'", previousValue);
        }

        if (previousValue instanceof List || previousValue instanceof Map) {
            return COMPLEX_VALUE_PLACEHOLDER;
        }

        return previousValue;
    }

    @Override
    public String toString() {
        return operationType.getFn().apply(this);
    }

}
