package tobyspringboot.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HelloControllerTest {

    @Test
    @DisplayName("HelloControllerTest")
    void HelloControllerTest(){
        HelloController helloController = new HelloController(name -> name);

        String result = helloController.hello("Test");

        System.out.println(result);

        Assertions.assertThat(result).isEqualTo("Test");
    }
    
    @Test
    @DisplayName("failHelloControllerTest")
    void failHelloControllerTest(){
        HelloController helloController = new HelloController(name -> name);

        Assertions.assertThatThrownBy(()->{
            String result = helloController.hello(null);
        }).isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(()->{
            String result = helloController.hello("");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
