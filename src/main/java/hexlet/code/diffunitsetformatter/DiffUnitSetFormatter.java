package hexlet.code.diffunitsetformatter;

import hexlet.code.diffunit.DiffUnit;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

/**
 * Принимает на вход List<DiffUnit>.
 */
public interface DiffUnitSetFormatter {

    String format(@NotNull Set<DiffUnit> diffUnitSet);

}
