package com.example.camel.router;

import com.example.camel.processor.TimerProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyRouter extends RouteBuilder {

    @Autowired
    private TimerProcessor timerProcessor;

    @Override
    public void configure() throws Exception {
        // timer：触发计时器 每秒输出日志
/*        from("timer:foo")
                .process(timerProcessor)
                .to("log:bar");*/

        restConfiguration()
                .component("servlet")
                .bindingMode(RestBindingMode.json);

        rest().get("/hello").to("direct:hello");
    }

}
