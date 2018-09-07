package com.yh.asctext.controller;


import com.yh.asctext.domain.ASCText;
import com.yh.asctext.service.SolutionService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletResponse;

@Controller
public class IndexController {
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
    @Autowired
    private SolutionService solutionService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView Index(HttpServletRequest request
            , HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        logger.info("aa");
        mav.setViewName("index");
        return mav;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/text; charset=utf8")
    public ModelAndView Solution(HttpServletRequest request
            , HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();

        String text = request.getParameter("text");
        String unit = request.getParameter("unit");
        ASCText ascText = solutionService.Sort(text, Integer.parseInt(unit));

        mav.setViewName("index");
        mav.addObject("result", ascText);

        return mav;
    }
}