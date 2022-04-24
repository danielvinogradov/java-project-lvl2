package hexlet.code.fileparser.defaultfileparser.util;

import org.jetbrains.annotations.NotNull;

import java.util.Map;

/**
 * Парсит данные (json/yaml). На вход в parse принимается строка (скорее всего результат чтения файла).
 */
public interface StringParser {

    /**
     * Получает данные в виде строки и возвращает распаршенный вариант в виде мапы.
     *
     * @param s Строка с данными (в текущей реализации это json или yaml в виде строки).
     * @return Результат парсинга в формате мапы.
     * @throws StringParserException Ошибка парсинга строки.
     */
    Map<String, Object> parse(@NotNull final String s) throws StringParserException;

}
