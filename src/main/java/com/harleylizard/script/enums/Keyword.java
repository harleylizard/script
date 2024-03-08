package com.harleylizard.script.enums;

public enum Keyword {
    IMPORT,
    DATA,
    FUNCTION;

    public static Keyword get(String s) {
        return switch (s) {
            case "import" -> IMPORT;
            case "data" -> DATA;
            case "function" -> FUNCTION;

            default -> throw new RuntimeException("Unknown keyword %s".formatted(s));
        };
    }
}
