package tobyspringboot.config.autoConfig;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.env.Environment;
import tobyspringboot.config.MyAutoConfiguration;
import tobyspringboot.config.MyConfigurationProperties;

import java.util.Map;

@MyAutoConfiguration
public class PropertyPostProcessorConfig {
    @Bean
    BeanPostProcessor propertyPostProcessor(Environment env){
        return new BeanPostProcessor() {
            //Bean의 모든 초기화가 끝난 뒤 이 프로세스를 호출하라. 라는 류의 메소드다.
            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                MyConfigurationProperties annotation = AnnotationUtils.findAnnotation(bean.getClass(), MyConfigurationProperties.class);

                if(annotation==null) return bean;

                Map<String, Object> attri = AnnotationUtils.getAnnotationAttributes(annotation);
                String prefix = (String) attri.get("prefix");

                return Binder.get(env).bindOrCreate(prefix,bean.getClass());
            }
        };
    }
}
