package com.camel.springbootcamelkafkaintegration.processor;

import org.springframework.stereotype.Component;


/**
 * MyTransformer class converts an simple string to LowerCase string
 * for instance the imput "HELLO WORLD!" it must return "hello world!".
 *
 * @author  José Alberto Flores Ramírez.
 * @version 1.0
 * @since   2019-06-01
 */
@Component
public class MyTransformer {

    public String transformContent(String body){
        String uppercaseContent = body.toLowerCase();
        return  uppercaseContent;
    }

}
