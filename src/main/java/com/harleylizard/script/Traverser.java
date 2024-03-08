package com.harleylizard.script;

import java.util.List;

public final class Traverser<T> {
    private final List<T> list;
    private int i;

    private Traverser(List<T> list) {
        this.list = list;
    }

    public T current() {
        return list.get(i);
    }

    public void next() {
        i = Math.min(i + 1, list.size() - 1);
    }

    public void previous() {
        i = Math.max(i - 1, 0);
    }

    public boolean hasNext() {
        return i < list.size() - 1;
    }

    public Traverser<T> copy() {
        var copy = new Traverser<>(list);
        copy.i = i;
        return copy;
    }

    public static <T> Traverser<T> of(List<T> list) {
        return new Traverser<>(list);
    }
}
