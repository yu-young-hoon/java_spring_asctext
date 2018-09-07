package com.yh.asctext.logic;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Logic {
    public String XSS(String text) {
        StringBuilder sb = new StringBuilder();
        char[] textChars = text.toCharArray();
        for (char ch : textChars) {
            if (('A' <= ch && ch <= 'Z') ||
                    ('a' <= ch && ch <= 'z') ||
                    ('0' <= ch && ch <= '9')) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public List<Character>[] Divide(String text) {
        List<Character>[] divideText = new List[2];
        return divideText;
    }

    public String Merge(List<Character> chars , List<Character> numbers) {
        StringBuilder sb = new StringBuilder();
        return sb.toString();
    }
}
