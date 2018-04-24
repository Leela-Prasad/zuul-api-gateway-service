package com.microservices.zuul.gateway.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class ZuulApiGatewayServiceApplication {
	/**
	 * Generally all clients will invoke microservices through 
	 * API Gateway(Zuul Proxy)
	 * If any client want to invoke microservice through Zuul Proxy
	 * then the url is
	 * http(s)://{zuul-server-name}:{zuul-port}/{microservice-application-name}/{microservice-request-mapping-uri}
	 * eg: Url for invoking currency exchange service through zuul is as below. 
	 * http://localhost:8765/currency-exchange-service/currency-exchange/from/USD/to/INR
	 * 
	 */
	public static void main(String[] args) {
		SpringApplication.run(ZuulApiGatewayServiceApplication.class, args);
	}
}
