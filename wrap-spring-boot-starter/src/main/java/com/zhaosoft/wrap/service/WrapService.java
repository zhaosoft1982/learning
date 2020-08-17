package com.zhaosoft.wrap.service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WrapService {
    private String before;
    private String after;

    public String swap(String word) {
        return before + word + after;
    }
}
