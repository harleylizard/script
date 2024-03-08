package com.harleylizard.script.enums;

import java.util.regex.Pattern;

public enum Delimiter {
    OPEN_CURLY_BRACKET,
    CLOSE_CURLY_BRACKET,
    OPEN_SQUARE_BRACKET,
    CLOSE_SQUARE_BRACKET,
    OPEN_PARENTHESIS,
    CLOSE_PARENTHESIS,
    OPEN_CARROT,
    CLOSE_CARROT;

    public static final Pattern PATTERN = Pattern.compile("[<\\[{(\\[\\])}>]");

    public static Delimiter get(String s) {
        return switch (s) {
            case "{" -> OPEN_CURLY_BRACKET;
            case "}" -> CLOSE_CURLY_BRACKET;
            case "[" -> OPEN_SQUARE_BRACKET;
            case "]" -> CLOSE_SQUARE_BRACKET;
            case "(" -> OPEN_PARENTHESIS;
            case ")" -> CLOSE_PARENTHESIS;
            case "<" -> OPEN_CARROT;
            case ">" -> CLOSE_CARROT;

            default -> throw new RuntimeException("Unknown delimiter %s".formatted(s));
        };
    }
}
