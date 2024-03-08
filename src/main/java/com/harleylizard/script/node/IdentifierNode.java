package com.harleylizard.script.node;

public final class IdentifierNode implements Node {
    private final String string;

    public IdentifierNode(String string) {
        this.string = string;
    }
}
