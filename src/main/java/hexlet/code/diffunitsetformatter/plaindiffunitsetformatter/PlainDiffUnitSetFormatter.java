package hexlet.code.diffunitsetformatter.plaindiffunitsetformatter;

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

public final class PlainDiffUnitSetFormatter implements DiffUnitSetFormatter {

    @Override
    public String format(@NotNull Set<DiffUnit> diffUnitSet) {
        List<Line> lineList = new ArrayList<>();

        final Consumer<DiffUnit> diffUnitConsumer = (DiffUnit diffUnit) -> {
            DiffUnitType diffUnitType = diffUnit.getType();
            String key = diffUnit.getKey();
            Object previousValue = diffUnit.getPreviousValue();
            Object currentValue = diffUnit.getCurrentValue();

            switch (diffUnitType) {
                case CHANGED:
                    lineList.add(new Line(OperationType.CHANGE, key, currentValue, previousValue));
                    break;
                case ADDED:
                    lineList.add(new Line(OperationType.ADDITION, key, currentValue, previousValue));
                    break;
                case DELETED:
                    lineList.add(new Line(OperationType.DELETION, key, currentValue, previousValue));
                    break;
                case UNCHANGED:
                default:
            }
        };

        diffUnitSet.stream()
                .sorted(Comparator.comparing(DiffUnit::getKey))
                .forEachOrdered(diffUnitConsumer);

        return lineList.stream()
                .map(Line::toString)
                .collect(Collectors.joining("\n"));
    }

}
