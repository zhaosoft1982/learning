package com.zhaosoft.demo.service.impl;

import com.zhaosoft.demo.service.IDemoService;
import com.zhaosoft.mvcframework.annotation.ZSService;

@ZSService
public class DemoService implements IDemoService {
    public String get(String name) {
        return "My name is" + name;
    }
}
