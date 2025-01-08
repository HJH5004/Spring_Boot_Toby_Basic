package tobyspringboot.helloboot;


import org.springframework.boot.SpringApplication;
import tobyspringboot.config.MySpringBootApplication;


@MySpringBootApplication
public class TobySpringBootApplication {


    public static void main(String[] args) {
//        MySpringApplication.run(TobySpringBootApplication.class, args);
        SpringApplication.run(TobySpringBootApplication.class, args);
    }

}
