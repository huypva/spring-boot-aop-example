package io.codebyexample.springbootaop.entrypoint;

import io.codebyexample.springbootaop.aop.TimeLogger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huypva
 */
@RestController
public class Controller {

  @TimeLogger(value = "greet")
  @GetMapping("/greet")
  public Greeting greet(@RequestParam(name = "name") String name) {
    String message = String.format("Hello %s!", name);

    return new Greeting(message);
  }
}
