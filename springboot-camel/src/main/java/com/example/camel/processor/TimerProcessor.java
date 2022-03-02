package com.example.camel.processor;


import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class TimerProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        Message msg = exchange.getIn();
        exchange.getOut().setBody("yyyy" + System.currentTimeMillis());
    }

}
