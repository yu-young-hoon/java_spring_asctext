package com.yh.asctext.service;

import com.yh.asctext.controller.IndexController;
import com.yh.asctext.logic.Logic;
import com.yh.asctext.logic.SortStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SolutionService {
    private static final Logger logger = LoggerFactory.getLogger(SolutionService.class);

    @Autowired
    private Logic logic;

    public String Sort(String text) {
        text = logic.XSS(text);

        List<Character>[] divideText = logic.Divide(text);

        List<Character> chars = divideText[0];
        List<Character> numbers = divideText[1];

        Collections.sort(numbers);
        Collections.sort(chars, new SortStrategy());

        return logic.Merge(numbers, chars);
    }
}
