package hexlet.code.diffgenerator.defaultdiffgenerator;

import hexlet.code.diffgenerator.DiffGenerator;
import hexlet.code.diffunit.DiffUnit;
import hexlet.code.diffunit.defaultdiffunit.DefaultDiffUnit;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class DefaultDiffGenerator implements DiffGenerator {

    @Override
    public Set<DiffUnit> process(@NotNull final Map<String, Object> data1, @NotNull final Map<String, Object> data2) {
        return Stream.concat(data1.keySet().stream(), data2.keySet().stream())
                .distinct()
                .map(key -> new DefaultDiffUnit(key,
                        data2.containsKey(key),
                        data2.get(key),
                        data1.containsKey(key),
                        data1.get(key)))
                .collect(Collectors.toSet());
    }

}
