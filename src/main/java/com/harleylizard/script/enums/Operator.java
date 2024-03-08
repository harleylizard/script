package com.harleylizard.script.enums;

public enum Operator {
    EQUAlS,
    PLUS,
    MINUS;

    public static Operator get(String s) {
        return switch (s) {
            case "=" -> EQUAlS;
            case "+" -> PLUS;
            case "-" -> MINUS;

            default -> throw new RuntimeException("Unknown operator %s".formatted(s));
        };
    }
}
