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
        ascText.setOutUnit(outUnit);

        Logic logic = new Logic(ascText);
        ascText = logic.filter().divide().sort().merge().getASCText();

        return ascText;
    }
}
