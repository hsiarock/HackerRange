package com.kph;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class KeyConvert {

    public static void main(String[] args) {
        KeyConvert keyConvert = new KeyConvert();

        Map<Integer, String> inp = new HashMap<>();
        inp.put(1, "val1");
        inp.put(2, "val2");
        inp.put(8, "val8");
        inp.put(4, "val4");
        inp.put(5, "val5");

        System.out.println(keyConvert.convertWithIteration(inp));
        System.out.println(keyConvert.convertWithStream(inp));
    }

    public String convertWithIteration(Map<Integer, ?> map) {
        StringBuilder mapAsString = new StringBuilder("{");
        for (Integer key : map.keySet()) {
            mapAsString.append(key + "=" + map.get(key) + ", ");
        }
        mapAsString.delete(mapAsString.length()-2, mapAsString.length()).append("}");
        return mapAsString.toString();
    }

    public String convertWithStream(Map<Integer, ?> map) {
        String mapAsString = map.keySet().stream()
                .map(key -> key + "=" + map.get(key))
                .collect(Collectors.joining(", ", "{", "}"));
        return mapAsString;
    }
}
