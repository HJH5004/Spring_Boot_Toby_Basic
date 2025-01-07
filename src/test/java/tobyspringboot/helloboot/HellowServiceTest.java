package tobyspringboot.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class HellowServiceTest {
    @Test
    void simpleHelloService(){
        SimpleHelloService helloService = new SimpleHelloService();

        String result = helloService.sayHello("Spring");

        Assertions.assertThat(result).isEqualTo("Hello Spring");
    }

    @Test
    void  helloDecorator(){
        HelloDecorator helloDecorator = new HelloDecorator(name -> name);

        String result = helloDecorator.sayHello("Test");

        Assertions.assertThat(result).isEqualTo("*Test*");

    }

}
