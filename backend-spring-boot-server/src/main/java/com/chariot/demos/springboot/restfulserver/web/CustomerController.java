package com.chariot.demos.springboot.restfulserver.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;

@RestController
@RequestMapping("/api/customers/")
public class CustomerController {

  @Autowired
  private DataSource dataSource;

  @PostMapping("vip-form")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public String processVIPForm(@RequestBody String requestBody) {
    System.out.println(dataSource.toString());
    System.out.println(requestBody);
    return "";
  }
}
