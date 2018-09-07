package com.yh.asctext.logic;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
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
        List<Character> chars = new ArrayList<>();
        List<Character> numbers = new ArrayList<>();

        for (int i = 0; i < text.length() ; i++) {
            Character ch = new Character(text.charAt(i));
            if(ch > '9')
                chars.add(ch);
            else
                numbers.add(ch);
        }
        divideText[0] = chars;
        divideText[1] = numbers;
        return divideText;
    }

    public String Merge(List<Character> chars , List<Character> numbers) {
        StringBuilder sb = new StringBuilder();
        int piv1 = 0, piv2 = 0;
        while(piv1 < chars.size() || piv2 < numbers.size()) {
            if(piv1 < chars.size())
                sb.append(chars.get(piv1++));
            if(piv2 < numbers.size())
                sb.append(numbers.get(piv2++));
        }
        return sb.toString();
    }
}