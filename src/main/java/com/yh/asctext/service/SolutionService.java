package com.yh.asctext.service;

import com.yh.asctext.domain.ASCText;
import com.yh.asctext.logic.Logic;
import com.yh.asctext.logic.SortStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class SolutionService {
    @Autowired
    private Logic logic;

    public ASCText Sort(String text, int outUnit) {
        ASCText ascText = new ASCText();
        ascText.setOriginText(text);

        text = logic.XSS(text);

        List<Character>[] divideText = logic.Divide(text);
        List<Character> chars = divideText[0];
        List<Character> numbers = divideText[1];
        Collections.sort(chars, new SortStrategy());
        Collections.sort(numbers);

        String mergedText = logic.Merge(chars, numbers);
        String result = mergedText.substring(0, mergedText.length() - mergedText.length() % outUnit);
        String tailText = mergedText.substring(mergedText.length() - mergedText.length() % outUnit);

        ascText.setOutUnit(outUnit);
        ascText.setResultText(result);
        ascText.setTailText(tailText);

        return ascText;
    }
}
