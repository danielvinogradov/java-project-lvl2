package hexlet.code.diffunitsetformatter.stylishdiffunitsetformatter;

import hexlet.code.diffunit.DiffUnit;
import hexlet.code.diffunit.DiffUnitType;
import hexlet.code.diffunitsetformatter.DiffUnitSetFormatter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public final class StylishDiffUnitSetFormatter implements DiffUnitSetFormatter {

    @Override
    public String format(@NotNull final Set<DiffUnit> diffUnitSet) {
        final List<Line> lineList = new ArrayList<>();

        final Consumer<DiffUnit> diffUnitConsumer = (DiffUnit diffUnit) -> {
            DiffUnitType diffUnitType = diffUnit.getType();
            String key = diffUnit.getKey();
            Object previousValue = diffUnit.getPreviousValue();
            Object currentValue = diffUnit.getCurrentValue();

            switch (diffUnitType) {
                case CHANGED:
                    lineList.add(new Line(OperationType.DELETION, key, previousValue));
                    lineList.add(new Line(OperationType.ADDITION, key, currentValue));
                    break;
                case ADDED:
                    lineList.add(new Line(OperationType.ADDITION, key, currentValue));
                    break;
                case DELETED:
                    lineList.add(new Line(OperationType.DELETION, key, previousValue));
                    break;
                case UNCHANGED:
                    lineList.add(new Line(OperationType.UNCHANGED, key, currentValue));
                    break;
                default:
            }
        };

        diffUnitSet.stream()
                .sorted(Comparator.comparing(DiffUnit::getKey))
                .forEachOrdered(diffUnitConsumer);

        final String formattedData = lineList.stream()
                .map(Line::toString)
                .collect(Collectors.joining(""));

        return String.format("{%n%s}", formattedData);
    }

}
