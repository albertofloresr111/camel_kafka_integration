package com.moneygram.demo.springbootcamelkafkaintegration.route;

import com.moneygram.demo.springbootcamelkafkaintegration.processor.MyTransformer;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class SimpleRouteBuilder extends RouteBuilder {

    private static final String KAFKA_SERVER    = "kafka://localhost:9092?";
    private static final String TOPIC_NAME      = "topic=testing";
    private static final String BROKER_NAME     = "&brokers=localhost:9092";
    private static final String INBOX_PATH      = "/home/aguilas/IdeaProjects/spring-boot-camel-kafka-integration/src/main/resources";


    @Override
    public void configure() throws Exception {

        String toKafkaUri = KAFKA_SERVER + TOPIC_NAME + BROKER_NAME;

        from("file:" + INBOX_PATH + "/inbox?noop=true")
                .split()
                .tokenize("\n")
                .bean( new MyTransformer(), "transformContent")
                .to(toKafkaUri);

    }
}