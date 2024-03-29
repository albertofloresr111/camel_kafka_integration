package com.camel.springbootcamelkafkaintegration.route;

import com.camel.springbootcamelkafkaintegration.processor.MyTransformer;
import org.apache.camel.builder.RouteBuilder;
/**
 * SimpleRouteBuilder class show how easily you can route files from a
 * inbox folder to a KAFKA message borker
 *
 * @author  José Alberto Flores Ramírez.
 * @version 1.0
 * @since   2019-06-01
 */
public class SimpleRouteBuilder extends RouteBuilder {

    private static final String KAFKA_HOST_SERVER   = "kafka://localhost:9092?";
    private static final String KAFKA_TOPIC_NAME    = "topic=testing";
    private static final String KAFKA_BROKER_NAME   = "&brokers=localhost:9092";

    private static final String SOURCE = "file:/home/aguilas/IdeaProjects/spring-boot-camel-kafka-integration/src/main/resources/inbox?noop=true";

    @Override
    public void configure() throws Exception {

        String destination = KAFKA_HOST_SERVER + KAFKA_TOPIC_NAME + KAFKA_BROKER_NAME;

        from( SOURCE )
                .split()
                .tokenize("\n")
                .bean( new MyTransformer(), "transformContent")
                .to(destination);

    }
}