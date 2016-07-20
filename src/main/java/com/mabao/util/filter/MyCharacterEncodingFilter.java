package com.mabao.util.filter;

import org.springframework.web.filter.CharacterEncodingFilter;

public class MyCharacterEncodingFilter extends CharacterEncodingFilter {
    private final String encoding = "UTF-8";

    public MyCharacterEncodingFilter(){
        super();
        super.setEncoding(this.encoding);
        super.setForceEncoding(true);
    }
}
