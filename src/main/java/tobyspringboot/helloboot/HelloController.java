package tobyspringboot.helloboot;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class HelloController  {
    private final HelloService helloService;

    ///Spring이 HelloService 구현체를 찾아서 알아서 넣어줌
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    public String hello(String name){
        if(null == name || name.trim().length()  == 0 ) throw new IllegalArgumentException();
        return helloService.sayHello(Objects.requireNonNull(name));
    }

    @GetMapping("/count")
    public String count(String name){
        return name + " : " + helloService.countOf(Objects.requireNonNull(name));
    }
}
