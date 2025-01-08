package tobyspringboot.config;

import org.springframework.context.annotation.Import;
import tobyspringboot.config.autoConfig.DispatcherServletConfig;
import tobyspringboot.config.autoConfig.TomcatWebServerConfig;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(MyAutoConfigurationImportSelector.class)
public @interface EnableMyAutoConfiguration {
}
