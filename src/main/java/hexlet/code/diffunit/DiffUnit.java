package hexlet.code.diffunit;

/**
 * Элемент различий.
 */
public interface DiffUnit {

    String getKey();

    Object getCurrentValue();

    Object getPreviousValue();

    DiffUnitType getType();

}
