package hexlet.code.diffunitsetformatter.stylishdiffunitsetformatter;

import org.jetbrains.annotations.NotNull;

enum OperationType {

    ADDITION("+"),

    DELETION("-"),

    UNCHANGED(" ");

    private final String sign;

    OperationType(@NotNull final String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }

}
