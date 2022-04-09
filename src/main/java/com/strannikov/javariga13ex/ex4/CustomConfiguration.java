package com.strannikov.javariga13ex.ex4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomConfiguration  {

    @Bean
    public DummyLogger dummyLogger(){
        return new DummyLogger();
    }
    @Bean
    public ListUtil listUtility(){
        return new ListUtil();
    }
    @Bean("stringUtility ")
    public StringUtil stringUtil(){
        return new StringUtil();
    }

}
