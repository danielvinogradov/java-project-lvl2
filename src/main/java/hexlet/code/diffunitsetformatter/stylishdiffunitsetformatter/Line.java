package hexlet.code.diffunitsetformatter.stylishdiffunitsetformatter;

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
        return String.format("  %s %s: %s%n", operationType.getSign(), key, value);
    }

}
