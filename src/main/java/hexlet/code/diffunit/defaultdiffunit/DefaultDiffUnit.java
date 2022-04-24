package hexlet.code.diffunit.defaultdiffunit;

import hexlet.code.diffunit.DiffUnit;
import hexlet.code.diffunit.DiffUnitType;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * Дефолтная (в приложении единственная) имплементация DiffUnit.
 */
public final class DefaultDiffUnit implements DiffUnit {

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

    public DefaultDiffUnit(@NotNull String newKey,
                           final boolean newKeyExistsCurrent,
                           final Object newCurrentValue,
                           final boolean newKeyExistsPrevious,
                           final Object newPreviousValue) {
        this.key = newKey;
        this.currentValue = newCurrentValue;
        this.previousValue = newPreviousValue;
        setType(newCurrentValue, newPreviousValue, newKeyExistsCurrent, newKeyExistsPrevious);
    }

    /**
     * По предыдущему и текущему значению определяет статус (изменилось/удалено/добавлено и т.д.).
     *
     * @param currentValueP      Текущее значение.
     * @param previousValueP     Предыдущее значение.
     * @param keyExistsCurrent  Существует ли ключ сейчас.
     * @param keyExistsPrevious Существовал ли ключ раньше.
     */
    private void setType(final Object currentValueP,
                         final Object previousValueP,
                         final boolean keyExistsCurrent,
                         final boolean keyExistsPrevious) {
        if (!keyExistsCurrent) {
            // значение удалено
            type = DiffUnitType.DELETED;
        } else if (!keyExistsPrevious) {
            // значение добавлено
            type = DiffUnitType.ADDED;
        } else if (currentValueP == null ? Objects.isNull(previousValueP) : currentValueP.equals(previousValueP)) {
            // значение не изменилось
            type = DiffUnitType.UNCHANGED;
        } else {
            // значение изменилось
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
