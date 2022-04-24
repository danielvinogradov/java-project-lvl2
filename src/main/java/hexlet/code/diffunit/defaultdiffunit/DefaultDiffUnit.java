package hexlet.code.diffunit.defaultdiffunit;

import hexlet.code.diffunit.DiffUnit;
import hexlet.code.diffunit.DiffUnitType;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * Дефолтная (в приложении единственная) имплементация DiffUnit.
 */
public class DefaultDiffUnit implements DiffUnit {

    /**
     * Ключ.
     */
    private final String key;

    /**
     * Текущее значение (т.е. значение во втором файле).
     */
    private final Object currentValue;

    /**
     * Предыдущее значение (т.е. значение в первом файле).
     */
    private final Object previousValue;

    /**
     * Тип произошедших изменений (значение изменилось/удалено/добавлено и т.д.).
     */
    private DiffUnitType type;

    public DefaultDiffUnit(@NotNull String key,
                           final boolean keyExistsCurrent,
                           final Object currentValue,
                           final boolean keyExistsPrevious,
                           final Object previousValue) {
        this.key = key;
        this.currentValue = currentValue;
        this.previousValue = previousValue;
        setType(currentValue, previousValue, keyExistsCurrent, keyExistsPrevious);
    }

    /**
     * По предыдущему и текущему значению определяет статус (изменилось/удалено/добавлено и т.д.).
     *
     * @param currentValue  Текущее значение.
     * @param previousValue Предыдущее значение.
     */
    private void setType(final Object currentValue, final Object previousValue, final boolean keyExistsCurrent, final boolean keyExistsPrevious) {
        if (!keyExistsCurrent) { // значение удалено
            type = DiffUnitType.DELETED;
        } else if (!keyExistsPrevious) { // значение добавлено
            type = DiffUnitType.ADDED;
        } else if (currentValue == null ? Objects.isNull(previousValue) : currentValue.equals(previousValue)) { // значение не изменилось
            type = DiffUnitType.UNCHANGED;
        } else { // значение изменилось
            type = DiffUnitType.CHANGED;
        }
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public Object getCurrentValue() {
        return currentValue;
    }

    @Override
    public Object getPreviousValue() {
        return previousValue;
    }

    @Override
    public DiffUnitType getType() {
        return type;
    }

}
