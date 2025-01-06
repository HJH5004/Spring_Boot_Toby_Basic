package tobyspringboot.helloboot;


import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class HelloController  {
    private final HelloService helloService;
    private final ApplicationContext applicationContext;

    ///Spring이 HelloService 구현체를 찾아서 알아서 넣어줌
    public HelloController(HelloService helloService, ApplicationContext applicationContext) {
        this.helloService = helloService;
        this.applicationContext = applicationContext;
    }

    @GetMapping("/hello")
    public String hello(String name){
        return helloService.sayHello(Objects.requireNonNull(name));
    }
}
