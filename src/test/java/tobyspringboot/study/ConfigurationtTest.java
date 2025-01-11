package tobyspringboot.study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class  ConfigurationtTest {

    @Test
    void configuration(){
//        MyConfig myConfig = new MyConfig();
//
//        Bean1 bean1 = myConfig.bean1();
//        Bean2 bean2 = myConfig.bean2();
//
//        Assertions.assertThat(bean1.common).isSameAs(bean2.common);

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
        ac.register(MyConfig.class);
        ac.refresh();



        Bean1 bean1 = ac.getBean(Bean1.class);
        Bean2 bean2 = ac.getBean(Bean2.class);

        Assertions.assertThat(bean1.common).isSameAs(bean2.common);

    }

    @Test
    void proxyConfiguration(){
        MyConfigProxy myConfigProxy = new MyConfigProxy();

        Bean1 bean1 = myConfigProxy.bean1();
        Bean2 bean2 = myConfigProxy.bean2();

        Assertions.assertThat(bean1.common).isSameAs(bean2.common);
    }

    static class MyConfigProxy extends MyConfig{

        private Common common;

        @Override
        Common common() {
            if(null == common) this.common = super.common();

            return this.common;
        }
    }
    //false를 생성하면 싱글톤 패턴이 아니라 class에 명시 되어있는 것 처럼 의존성이 주입 됨 = Common 객체가 새로운걸로 2개 생성되게 된다.
//    @Configuration(proxyBeanMethods = false)
    @Configuration
    static class MyConfig {
        @Bean
        Common common(){
            return new Common();
        }

        @Bean
        Bean1 bean1(){
            return new Bean1(common());
        }

        @Bean
        Bean2 bean2(){
            return new Bean2(common());
        }
    }

    static class Bean1 {
        private final Common common;

        Bean1(Common common){
            this.common = common;
        }
    }

    static class Bean2 {
        private final Common common;

        Bean2(Common common){
            this.common = common;
        }
    }

    private static class Common {
    }
}
