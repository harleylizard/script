package com.harleylizard.script.node;

public final class ByteNode implements Node {
    private final byte b;

    public ByteNode(byte b) {
        this.b = b;
    }

    public byte getB() {
        return b;
    }
}
