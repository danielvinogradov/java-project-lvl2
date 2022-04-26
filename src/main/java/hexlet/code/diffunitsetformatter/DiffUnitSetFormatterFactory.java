package hexlet.code.diffunitsetformatter;

import hexlet.code.diffunitsetformatter.plaindiffunitsetformatter.PlainDiffUnitSetFormatter;
import hexlet.code.diffunitsetformatter.stylishdiffunitsetformatter.StylishDiffUnitSetFormatter;
import org.jetbrains.annotations.NotNull;

public final class DiffUnitSetFormatterFactory {

    private DiffUnitSetFormatterFactory() {
    }

    public static DiffUnitSetFormatter getFormatter(@NotNull final FormatType formatType) {
        return switch (formatType) {
            case PLAIN -> new PlainDiffUnitSetFormatter();
            case STYLISH -> new StylishDiffUnitSetFormatter();
        };
    }

}
