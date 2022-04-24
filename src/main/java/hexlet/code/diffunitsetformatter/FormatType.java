package hexlet.code.diffunitsetformatter;

import org.jetbrains.annotations.NotNull;

/**
 * Поддерживаемые типы форматирования.
 */
public enum FormatType {

    /**
     * Реализация {@link hexlet.code.diffunitsetformatter.stylishdiffunitsetformatter.StylishDiffUnitSetFormatter}.
     */
    STYLISH("stylish"),

    /**
     * Реализация {@link hexlet.code.diffunitsetformatter.plaindiffunitsetformatter.PlainDiffUnitSetFormatter}.
     */
    PLAIN("plain"),

    /**
     * Реализация {@link hexlet.code.diffunitsetformatter.jsondiffunitsetformatter.JsonDiffUnitSetFormatter}.
     */
    JSON("json");

    private final String description;

    FormatType(@NotNull String newDescription) {
        this.description = newDescription;
    }

    public static FormatType fromString(@NotNull String s) {
        for (FormatType formatType : FormatType.values()) {
            if (formatType.description.equals(s)) {
                return formatType;
            }
        }

        throw new NullPointerException();
    }

}
