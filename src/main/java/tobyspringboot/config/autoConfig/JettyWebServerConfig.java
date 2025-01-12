package tobyspringboot.config.autoConfig;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.ClassUtils;
import tobyspringboot.config.ConditionalMyOnClass;
import tobyspringboot.config.MyAutoConfiguration;

//imports를 활용한 Bean을 생성 할때는 @Configuration 어노테이션이 아니라 imports를 활용하는 어노테이션을 붙여서 해당 값이 imports 되어 들어온 값임을 표현한다.
@MyAutoConfiguration
//Conditionlal 에서 이 컨디션을 볼 수 있도록 할 수있음
@ConditionalMyOnClass("org.eclipse.jetty.server.Server")
public class JettyWebServerConfig {

    @Bean("jettyWebserverFactory")
    @ConditionalOnMissingBean
    public ServletWebServerFactory servletWebServerFactory(){
        return new JettyServletWebServerFactory();
    }
}
