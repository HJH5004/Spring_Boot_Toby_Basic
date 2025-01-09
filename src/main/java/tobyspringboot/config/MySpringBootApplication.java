package tobyspringboot.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//왜 Rentsntion을 Runttime으로 지정하는가? 서비스가 시작되고 끝나는 지점 까지 이 어노테이션에 대한 정보가 살아 있어야 하기 떄문

@Retention(RetentionPolicy.RUNTIME)
//Target은 calss, interfase, enum에 대상으로 적용하고 싶다면 TYPE을 사용하여야 한다.
@Target(ElementType.TYPE)
@Configuration
@ComponentScan
@EnableMyAutoConfiguration
public @interface MySpringBootApplication {
}
