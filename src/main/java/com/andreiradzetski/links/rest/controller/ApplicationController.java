package com.andreiradzetski.links.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Andrei Radzetski
 * @since 10.12.2017
 */
@RestController
public class ApplicationController {

  private static final String WELCOME_SERVER_MESSAGE = "Links server running...";

  @RequestMapping("/")
  public String index() {

    return WELCOME_SERVER_MESSAGE;
  }

}
