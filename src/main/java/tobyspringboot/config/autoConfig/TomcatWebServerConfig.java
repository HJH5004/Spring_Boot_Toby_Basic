package tobyspringboot.config.autoConfig;

import jakarta.websocket.server.ServerContainer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.*;
import tobyspringboot.config.ConditionalMyOnClass;
import tobyspringboot.config.EnableMyConfigurationProperties;
import tobyspringboot.config.MyAutoConfiguration;

//imports를 활용한 Bean을 생성 할때는 @Configuration 어노테이션이 아니라 imports를 활용하는 어노테이션을 붙여서 해당 값이 imports 되어 들어온 값임을 표현한다.
@MyAutoConfiguration
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat")
@EnableMyConfigurationProperties(ServerProperties.class)
public class TomcatWebServerConfig {


    //@Value 어노테이션에는 프로퍼티에서 가져온 값의 이름을 플레이스 홀더로 받아와서 필드값에 삽입하여 줍니다.
    @Value("${contextPath:}")
    String contextPath;

    // 만약 프로퍼티의 값이 없다면 이렇게 :--- 형태로 기본 값을 설정할 수 있다.
    @Value("${port:9090}")
    int port;

    @Bean("tomcatWebserverFactory")
    //이미 이것과 동일한 타입의 Class가 Bean에 등록되어 있는지 확인 하고 만약 등록 되어있다면 지금의 타입은 등록하지 않음.
    @ConditionalOnMissingBean
    public ServletWebServerFactory servletWebServerFactory(ServerProperties serverProperties){
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.setContextPath(serverProperties.getContextPath());
        factory.setPort(serverProperties.getPortNo());
        return factory;
    }

}
