package com.chariot.demos.springboot.restfulserver.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers/")
public class CustomerController {

  @PostMapping("vip-form")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public String processVIPForm(@RequestBody String requestBody) {
    System.out.println(requestBody);
    return "";
  }
}
