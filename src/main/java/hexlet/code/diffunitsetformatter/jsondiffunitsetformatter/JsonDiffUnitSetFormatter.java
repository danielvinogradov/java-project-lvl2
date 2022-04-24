package hexlet.code.diffunitsetformatter.jsondiffunitsetformatter;

import hexlet.code.diffunit.DiffUnit;
import hexlet.code.diffunitsetformatter.DiffUnitSetFormatter;
import hexlet.code.diffunitsetformatter.stylishdiffunitsetformatter.StylishDiffUnitSetFormatter;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public final class JsonDiffUnitSetFormatter implements DiffUnitSetFormatter {

    @Override
    public String format(@NotNull Set<DiffUnit> diffUnitSet) {
        return new StylishDiffUnitSetFormatter().format(diffUnitSet);
    }

}
