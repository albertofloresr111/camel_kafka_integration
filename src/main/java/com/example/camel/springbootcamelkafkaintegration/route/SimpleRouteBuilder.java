package com.example.camel.springbootcamelkafkaintegration.route;

import com.example.camel.springbootcamelkafkaintegration.processor.MyTransformer;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * SimpleRouteBuilder class show how easily you can route files from a
 * inbox folder to a KAFKA message borker
 *
 * @author  José Alberto Flores Ramírez.
 * @version 1.0
 * @since   2019-06-01
 */
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