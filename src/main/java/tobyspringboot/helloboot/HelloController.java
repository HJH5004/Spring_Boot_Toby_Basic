package tobyspringboot.helloboot;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;
import java.util.logging.Logger;

@RequestMapping("/hello")
public class HelloController {
    private final HelloService helloService;

    ///Spring이 HelloService 구현체를 찾아서 알아서 넣어줌
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping
    @ResponseBody
    public String hello(String name){
        return helloService.sayHello(Objects.requireNonNull(name));
    }
}
