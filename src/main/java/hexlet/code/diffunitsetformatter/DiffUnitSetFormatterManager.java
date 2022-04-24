package hexlet.code.diffunitsetformatter;

import hexlet.code.diffunitsetformatter.jsondiffunitsetformatter.JsonDiffUnitSetFormatter;
import hexlet.code.diffunitsetformatter.plaindiffunitsetformatter.PlainDiffUnitSetFormatter;
import hexlet.code.diffunitsetformatter.stylishdiffunitsetformatter.StylishDiffUnitSetFormatter;
import org.jetbrains.annotations.NotNull;

public final class DiffUnitSetFormatterManager {

    private DiffUnitSetFormatterManager() {
    }

    public static DiffUnitSetFormatter getFormatter(@NotNull final FormatType formatType) {
        switch (formatType) {
            case PLAIN:
                return new PlainDiffUnitSetFormatter();
            case STYLISH:
                return new StylishDiffUnitSetFormatter();
            case JSON:
                return new JsonDiffUnitSetFormatter();
            default:
                throw new UnsupportedOperationException();
        }
    }

}
