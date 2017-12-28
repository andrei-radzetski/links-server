package com.andreiradzetski.links;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @author Andrei Radzetski
 * @since 28.12.2017
 */
@SpringBootApplication
public class ExternalServerApplication extends SpringBootServletInitializer {

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

    return application.sources(ExternalServerApplication.class);
  }

  public static void main(String[] args) {

    SpringApplication.run(ExternalServerApplication.class, args);
  }

}
