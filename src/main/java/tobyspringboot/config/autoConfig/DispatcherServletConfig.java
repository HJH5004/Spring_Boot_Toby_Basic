package tobyspringboot.config.autoConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;
import tobyspringboot.config.MyAutoConfiguration;


//imports를 활용한 Bean을 생성 할때는 @Configuration 어노테이션이 아니라 imports를 활용하는 어노테이션을 붙여서 해당 값이 imports 되어 들어온 값임을 표현한다.
@MyAutoConfiguration
public class DispatcherServletConfig {

    @Bean
    public DispatcherServlet dispatcherServlet(){
        return  new DispatcherServlet();
    }
}

