package hexlet.code.diffunitsetformatter.plaindiffunitsetformatter;

import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public enum OperationType {

    ADDITION("added",
            (Line line) -> String.format("Property '%s' was added with value: %s", line.getKey(), line.getValue())),

    DELETION("removed",
            (Line line) -> String.format("Property '%s' was removed", line.getKey())),

    CHANGE("updated",
            (Line line) -> String.format("Property '%s' was updated. From %s to %s",
                    line.getKey(),
                    line.getPreviousValue(),
                    line.getValue()));

    private final String verb;

    private final Function<Line, String> fn;

    OperationType(@NotNull final String verb, @NotNull final Function<Line, String> fn) {
        this.verb = verb;
        this.fn = fn;
    }

    public String getVerb() {
        return verb;
    }

    public Function<Line, String> getFn() {
        return fn;
    }

}
