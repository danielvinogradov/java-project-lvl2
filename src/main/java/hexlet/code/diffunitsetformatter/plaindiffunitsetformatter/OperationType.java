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

    OperationType(@NotNull final String newVerb, @NotNull final Function<Line, String> newFn) {
        this.verb = newVerb;
        this.fn = newFn;
    }

    public String getVerb() {
        return verb;
    }

    public Function<Line, String> getFn() {
        return fn;
    }

}
