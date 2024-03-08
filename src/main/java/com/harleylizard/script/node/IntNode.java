package com.harleylizard.script.node;

public final class IntNode implements Node {
    private final int i;

    public IntNode(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }
}
