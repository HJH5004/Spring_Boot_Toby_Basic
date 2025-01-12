package tobyspringboot.config.autoConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import tobyspringboot.config.MyAutoConfiguration;

@MyAutoConfiguration
public class PropertyPlaceholderConfig {
    @Bean
    PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

}
