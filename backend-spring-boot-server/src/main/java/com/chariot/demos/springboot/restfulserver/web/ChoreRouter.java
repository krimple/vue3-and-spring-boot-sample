package com.chariot.demos.springboot.restfulserver.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class ChoreRouter {
  @Bean
  public RouterFunction<ServerResponse> route(ChoreHandlers choreHandlers) {
    return RouterFunctions.route(
        RequestPredicates.GET("/chores"), choreHandlers::getChores
    );
  }
}
