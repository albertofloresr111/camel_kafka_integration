package com.example.camel.springbootcamelkafkaintegration.processor;

import org.springframework.stereotype.Component;

@Component
public class MyTransformer {

    public String transformContent(String body){
        String uppercaseContent = body.toLowerCase();
        return  uppercaseContent;
    }

}
