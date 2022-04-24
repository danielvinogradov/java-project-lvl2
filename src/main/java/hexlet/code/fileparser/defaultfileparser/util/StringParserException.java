package hexlet.code.fileparser.defaultfileparser.util;

/**
 * Ошибка работы любого StringParser, т.е. ошибка преобразования строки в
 * Map<String, String>.
 *
 * Не имеет отношения к чтению файла.
 */
public final class StringParserException extends Exception {

    public StringParserException() {
        this("Произошла ошибка при обработке содержимого файла.");
    }

    public StringParserException(String message) {
        super(message);
    }

}
