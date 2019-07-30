package com.udemy.currencyzuulservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class CurrencyZuulApiGatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyZuulApiGatewayServiceApplication.class, args);
	}
	
	@Bean
	public Sampler defaulSampler(){
		return Sampler.ALWAYS_SAMPLE;
	}

}
