package com.camel.springbootcamelkafkaintegration;

import com.camel.springbootcamelkafkaintegration.route.SimpleRouteBuilder;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootCamelKafkaIntegrationApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringBootCamelKafkaIntegrationApplication.class, args);

		SimpleRouteBuilder routeBuilder = new SimpleRouteBuilder();
		CamelContext ctx = new DefaultCamelContext();

		try {
			ctx.addRoutes(routeBuilder);
			ctx.start();
			Thread.sleep(5 * 60 * 1000);
			ctx.stop();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}