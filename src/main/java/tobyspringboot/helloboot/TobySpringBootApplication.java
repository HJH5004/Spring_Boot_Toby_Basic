package tobyspringboot.helloboot;


import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import tobyspringboot.config.MySpringBootApplication;


//@MySpringBootApplication
@SpringBootApplication
public class TobySpringBootApplication {

    //프로 퍼티 우선 순위 : system 프로퍼티 > 환경 변수 > application.properties
//    @Bean
//    ApplicationRunner applicationRunner(Environment env){
//        return args -> {
//            String name = env.getProperty("my.name");
//            System.out.println("my.name = "+name);
//        };
//    }
    private final JdbcTemplate jdbcTemplate;

    public TobySpringBootApplication(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct
    void init(){
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS HELLO (NAME VARCHAR(50) PRIMARY KEY, COUNT INT)");
    }


    public static void main(String[] args) {
//        MySpringApplication.run(TobySpringBootApplication.class, args);
        SpringApplication.run(TobySpringBootApplication.class, args);
    }

}
