package tobyspringboot.helloboot;


import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import tobyspringboot.config.MySpringBootApplication;


@MySpringBootApplication
public class TobySpringBootApplication {

    //프로 퍼티 우선 순위 : system 프로퍼티 > 환경 변수 > application.properties
//    @Bean
//    ApplicationRunner applicationRunner(Environment env){
//        return args -> {
//            String name = env.getProperty("my.name");
//            System.out.println("my.name = "+name);
//        };
//    }

    public static void main(String[] args) {
//        MySpringApplication.run(TobySpringBootApplication.class, args);
        SpringApplication.run(TobySpringBootApplication.class, args);
    }

}
