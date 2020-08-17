package com.zhaosoft.demo.controller;

import com.zhaosoft.wrap.service.WrapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WrapController {

    @Autowired
    private WrapService wrapService;

    @RequestMapping("/wrap/{paramValue}")
    public String wrapHandle(@PathVariable("paramValue") String paramValue) {
        return wrapService.swap(paramValue);
    }
}
