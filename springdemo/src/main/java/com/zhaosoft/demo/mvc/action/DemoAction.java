package com.zhaosoft.demo.mvc.action;

import com.zhaosoft.demo.service.IDemoService;
import com.zhaosoft.mvcframework.annotation.ZSAutowired;
import com.zhaosoft.mvcframework.annotation.ZSController;
import com.zhaosoft.mvcframework.annotation.ZSRequestMapping;
import com.zhaosoft.mvcframework.annotation.ZSRequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ZSController
@ZSRequestMapping("/demo")
public class DemoAction {

    @ZSAutowired
    private IDemoService demoService;

    @ZSRequestMapping("/query")
    public void query(HttpServletRequest req, HttpServletResponse response, @ZSRequestParam("name") String name) {
        String result = demoService.get(name);
        try {
            response.getWriter().write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @ZSRequestMapping("add")
    public void add(HttpServletRequest req, HttpServletResponse response,
                    @ZSRequestParam("a") Integer a, @ZSRequestParam("b") Integer b) {
        try {
            response.getWriter().write(a + "+" + b + "=" + (a + b));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @ZSRequestMapping("/remove")
    public void remove(HttpServletRequest req, HttpServletResponse res, @ZSRequestParam("id") Integer id) {
    }

}
