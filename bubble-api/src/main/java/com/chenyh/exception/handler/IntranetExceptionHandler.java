package com.chenyh.exception.handler;

import com.chenyh.exception.IntranetException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class IntranetExceptionHandler {

    public static final String DEFAULT_ERROR_VIEW = "/error";


    public IntranetExceptionHandler() {
        System.out.println("初始化");
    }

    @ExceptionHandler(value = IntranetException.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ModelAndView mv = new ModelAndView();

        mv.addObject("exception", e);
        mv.addObject("url", req.getRequestURL());
        mv.setViewName(DEFAULT_ERROR_VIEW);
        return mv;
    }
}
