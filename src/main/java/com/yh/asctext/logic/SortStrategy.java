package com.yh.asctext.logic;

import java.util.Comparator;

public class SortStrategy implements Comparator<Character> {
    @Override
    public int compare(Character o1, Character o2) {
        if (Character.toUpperCase(o1) != Character.toUpperCase(o2)) {
            return Character.toUpperCase(o1) - Character.toUpperCase(o2);
        } else {
            return o1 - o2;
        }
    }
}