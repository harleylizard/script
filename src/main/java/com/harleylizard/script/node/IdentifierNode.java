package com.harleylizard.script.node;

public final class IdentifierNode implements Node {
    private final String identifier;

    public IdentifierNode(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }
}
