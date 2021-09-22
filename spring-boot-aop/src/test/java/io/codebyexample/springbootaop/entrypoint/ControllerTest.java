package io.codebyexample.springbootaop.entrypoint;

import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

/**
 * @author huypva
 */
@WebMvcTest(Controller.class)
class ControllerTest {

  @Autowired
  private MockMvc mockMvc;
  @Test
  void greet() throws Exception {
    String api = "/greet?name=World";
    Greeting greeting = new Greeting("Hello World!");

    ResultActions resultActions = mockMvc.perform(get(api))
        .andDo(print());

    resultActions.andExpect(status().isOk())
        .andExpect(jsonPath("$.id", is(greeting.getId())))
        .andExpect(jsonPath("$.message", is(greeting.getMessage())));
  }
}