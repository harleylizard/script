package com.harleylizard.script.node;

public final class EnumNode<T extends Enum<T>> implements Node {
    private final T t;

    public EnumNode(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }
}
