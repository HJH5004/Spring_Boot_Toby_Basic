package tobyspringboot.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@UnitTest
@interface FestUnitTest{

}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE,ElementType.METHOD})
@Test
@interface UnitTest{

}

public class HellowServiceTest {
    @Test
    void simpleHelloService(){
        SimpleHelloService helloService = new SimpleHelloService(new HelloRepository(){
            @Override
            public Hello findHello(String name) {
                return null;
            }

            @Override
            public void increaseCount(String name) {

            }
        });

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
