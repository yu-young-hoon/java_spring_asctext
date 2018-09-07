package com.yh.asctext.controller;


import com.yh.asctext.domain.ASCText;
import com.yh.asctext.service.SolutionService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

@Controller
public class IndexController {
    @Autowired
    private SolutionService solutionService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView Index(HttpServletRequest request
            , HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        return mav;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView Solution(HttpServletRequest request
            , HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();

        String text = request.getParameter("text");
        String unit = request.getParameter("unit");
        int iunit;
        try {
            iunit = Integer.parseInt(unit);
        } catch (NumberFormatException ex) {
            iunit = 0;
        }

        ASCText ascText = solutionService.Sort(text, iunit);

        mav.setViewName("index");
        mav.addObject("result", ascText);

        return mav;
    }
}