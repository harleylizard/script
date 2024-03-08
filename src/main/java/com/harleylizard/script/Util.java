package com.harleylizard.script;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class Util {

    private Util() {}

    public static <T> List<T> toImmutable(List<T> list) {
        return list.isEmpty() ? List.of() : Collections.unmodifiableList(list);
    }

    public static <K, V> Map<K, V> toImmutable(Map<K, V> map) {
        return map.isEmpty() ? Map.of() : Collections.unmodifiableMap(map);
    }
}
