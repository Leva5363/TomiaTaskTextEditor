package com.ramilaiv.tomiatesttasktesteditor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
public class TomiaTestTaskTestEditorApplication {

	public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(TomiaTestTaskTestEditorApplication.class);
        builder.headless(false);
        ConfigurableApplicationContext context = builder.run(args);
//		SpringApplication.run(TomiaTestTaskTestEditorApplication.class, args);
	}

}
