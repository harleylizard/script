package com.harleylizard.script.node;

public final class DoubleNode implements Node {
    private final double d;

    public DoubleNode(double d) {
        this.d = d;
    }

    public double getD() {
        return d;
    }
}
