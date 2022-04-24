package hexlet.code.diffgenerator;

import hexlet.code.diffunit.DiffUnit;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.Set;

/**
 * Создает дифф между мапами.
 */
public interface DiffGenerator {

    /**
     * @param data1
     * @param data2
     * @return
     */
    Set<DiffUnit> process(@NotNull final Map<String, Object> data1, @NotNull final Map<String, Object> data2);

}
