package com.harleylizard.script.enums;

public enum DataType {
    BYTE,
    INT,
    FLOAT,
    DOUBLE;

    public static DataType get(String s) {
        return switch (s) {
            case "byte" -> BYTE;
            case "int" -> INT;
            case "float" -> FLOAT;
            case "double" -> DOUBLE;
            default -> throw new RuntimeException("Unknown DataType %s".formatted(s));
        };
    }
}
