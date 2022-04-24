package hexlet.code.diffunitsetformatter.stylishdiffunitsetformatter;

import org.jetbrains.annotations.NotNull;

final class Line {

    private final OperationType operationType;

    private final String key;

    private final Object value;

    public Line(@NotNull final OperationType operationType, @NotNull final String key, @NotNull final Object value) {
        this.operationType = operationType;
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("  %s %s: %s%n", operationType.getSign(), key, value);
    }

}
