package com.harleylizard.script.tree;

public sealed interface Tree permits ListTree, MapTree, ObjectTree {

    @SuppressWarnings("unchecked")
    default <T extends Tree> T unsafeCast() {
        return (T) this;
    }
}
