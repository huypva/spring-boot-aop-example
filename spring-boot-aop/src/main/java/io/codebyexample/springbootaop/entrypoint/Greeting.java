package io.codebyexample.springbootaop.entrypoint;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * @author huypva
 */
@Setter
@Getter
@AllArgsConstructor
public class Greeting {

  private int id;
  private String message;

  public Greeting(String message) {
    this.message = message;
  }

}
