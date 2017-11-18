package com.ilkaygunel.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableCaching
@ComponentScan(basePackages = {"com.ilkaygunel.runner"})
@ComponentScan(basePackages = {"com.ilkaygunel.interfaces"})
@ComponentScan(basePackages = {"com.ilkaygunel.interfaceimpl"})
@ComponentScan(basePackages = {"com.ilkaygunel.pojo"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}