package com.harleylizard.script.tree;

public final class ObjectTree<T> implements Tree {
    private final T t;

    public ObjectTree(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }
}
