package tobyspringboot.config.autoConfig;

import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.type.AnnotatedTypeMetadata;
import tobyspringboot.config.MyAutoConfiguration;

//imports를 활용한 Bean을 생성 할때는 @Configuration 어노테이션이 아니라 imports를 활용하는 어노테이션을 붙여서 해당 값이 imports 되어 들어온 값임을 표현한다.
@MyAutoConfiguration
//Conditionlal 에서 이 컨디션을 볼 수 있도록 할 수있음
@Conditional(JettyWebServerConfig.JettyCondition.class)
public class JettyWebServerConfig {

    @Bean("jettyWebserverFactory")
    public ServletWebServerFactory servletWebServerFactory(){
        return new JettyServletWebServerFactory();
    }

    
    //목포 : 톰켓과 제티 중 제티가 돌아갈 수 있도록 하고 싶음
    //Conditional 컴포넌트를 선선한 뒤 matches가 true면 이걸 띄우겠다는 뜻이다
    static class JettyCondition implements Condition {
        @Override
        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
            return true;
        }
    }
}
