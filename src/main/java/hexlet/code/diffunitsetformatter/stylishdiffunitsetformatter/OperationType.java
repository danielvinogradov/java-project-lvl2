package hexlet.code.diffunitsetformatter.stylishdiffunitsetformatter;

import org.jetbrains.annotations.NotNull;

enum OperationType {

    ADDITION("+"),

    DELETION("-"),

    UNCHANGED(" ");

    private final String sign;

    OperationType(@NotNull final String newSign) {
        this.sign = newSign;
    }

    public String getSign() {
        return sign;
    }

}
