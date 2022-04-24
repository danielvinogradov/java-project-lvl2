package hexlet.code.diffgenerator;

import hexlet.code.diffunit.DiffUnit;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.Set;

/**
 * Генератор разницы между значениями ключей в мапах.
 */
public interface DiffGenerator {

    /**
     * Сгенерировать diff.
     * <p>
     * Возвращаемое значение имеет форму множества DiffUnit. Класс, реализующий интерфейс DiffUnit
     * должен хранить информацию о состоянии одного ключа и его значения (и предыдущего значения,
     * если оно есть). Для ключей, отсутствующих в одной из мап или имеющих одинаковое значение,
     * также должен быть сгенерирован DiffUnit.
     *
     * @param data1 Первая мапа.
     * @param data2 Вторая мапа.
     * @return Множество DiffUnit.
     */
    Set<DiffUnit> process(@NotNull Map<String, Object> data1, @NotNull Map<String, Object> data2);

}
