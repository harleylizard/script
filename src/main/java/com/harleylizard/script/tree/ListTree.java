package com.harleylizard.script.tree;

import java.util.List;

public final class ListTree<T> implements Tree {
    private static final ListTree<?> EMPTY = new ListTree<>(List.of());

    private final List<T> list;

    public ListTree(List<T> list) {
        this.list = list;
    }

    public List<T> getList() {
        return list;
    }

    @SuppressWarnings("unchecked")
    public static <T> ListTree<T> empty() {
        return (ListTree<T>) EMPTY;
    }
}
