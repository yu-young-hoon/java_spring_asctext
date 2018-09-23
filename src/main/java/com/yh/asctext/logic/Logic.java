package com.yh.asctext.logic;

import com.yh.asctext.domain.ASCText;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@Scope(value="session")
public class Logic {
    private String filtedText;
    private List<Character> chars;
    private List<Character> numbers;
    private String mergedText;
    private ASCText ascText;

    public Logic(ASCText ascText) {
        this.ascText = ascText;
    }

    public ASCText getASCText(){
        return this.ascText;
    }

    public Logic filter() {
        StringBuilder sb = new StringBuilder();
        char[] textChars = ascText.getOriginText().toCharArray();
        for (char ch : textChars) {
            if (('A' <= ch && ch <= 'Z') ||
                    ('a' <= ch && ch <= 'z') ||
                    ('0' <= ch && ch <= '9')) {
                sb.append(ch);
            }
        }
        this.filtedText = sb.toString();
        return this;
    }

    public Logic divide() {
        List<Character> chars = new ArrayList<>();
        List<Character> numbers = new ArrayList<>();

        for (int i = 0; i < this.filtedText.length() ; i++) {
            Character ch = new Character(this.filtedText.charAt(i));
            if(ch > '9')
                chars.add(ch);
            else
                numbers.add(ch);
        }
        this.chars = chars;
        this.numbers = numbers;

        return this;
    }

    public Logic sort() {
        Collections.sort(chars, new SortStrategy());
        Collections.sort(numbers);

        return this;
    }

    public Logic merge() {
        StringBuilder sb = new StringBuilder();
        int piv1 = 0, piv2 = 0;
        while(piv1 < this.chars.size() || piv2 < this.numbers.size()) {
            if(piv1 < this.chars.size())
                sb.append(this.chars.get(piv1++));
            if(piv2 < this.numbers.size())
                sb.append(this.numbers.get(piv2++));
        }
        this.mergedText = sb.toString();
        String result = mergedText.substring(0, mergedText.length() - mergedText.length() % ascText.getOutUnit());
        String tailText = mergedText.substring(mergedText.length() - mergedText.length() % ascText.getOutUnit());

        this.ascText.setResultText(result);
        this.ascText.setTailText(tailText);

        return this;
    }
}