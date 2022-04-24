package hexlet.code.fileparser;

import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;

/**
 * Типы обрабатываемого файла, для которых должен поддерживаться парсинг.
 */
public enum FileType {

    /**
     * @see <a href="https://en.wikipedia.org/wiki/JSON">Wiki: JSON</a>
     */
    JSON(".json"),

    /**
     * @see <a href="https://en.wikipedia.org/wiki/YAML">Wiki: YAML</a>
     */
    YAML(".yml");

    /**
     * Расширение файла.
     */
    private final String extension;

    FileType(@NotNull final String newExtension) {
        this.extension = newExtension;
    }

    /**
     * Получить тип файла по его пути.
     *
     * @param path Путь файла.
     * @return Тип файла.
     */
    public static FileType fromPath(@NotNull final Path path) {
        String pathString = path.toString();

        for (FileType fileType : FileType.values()) {
            if (pathString.endsWith(fileType.extension)) {
                return fileType;
            }
        }

        return null;
    }

}
