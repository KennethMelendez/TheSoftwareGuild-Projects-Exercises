package com.sg.hellosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ContentController {

    @RequestMapping(value="/content", method=RequestMethod.GET)
    public String displayContentPage() {
        return "content";
    }
}
