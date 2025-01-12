package tobyspringboot.study;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.context.annotation.*;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ConditionalTest {

    @Test
    void condition(){
        // true
        ApplicationContextRunner contextRunner = new ApplicationContextRunner();
        contextRunner.withUserConfiguration(Config1.class)
                .run( context ->{
                    assertThat(context).hasSingleBean(MyBean.class);
                    assertThat(context).hasSingleBean(Config1.class);
                });
        //false
        new ApplicationContextRunner().withUserConfiguration(Config2.class)
                .run( context ->{
                    assertThat(context).doesNotHaveBean(MyBean.class);
                    assertThat(context).doesNotHaveBean(Config2.class);
                });
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @Conditional(BooleanCondition.class)
    @interface BooleanConditional{
        boolean value();
    }


//    @Retention(RetentionPolicy.RUNTIME)
//    @Target(ElementType.TYPE)
//    @Conditional(FalseCondition.class)
//    @interface FalseConditional{}


    @Configuration
    @BooleanConditional(true)
    static class Config1{
        @Bean
        MyBean  myBean(){
              return new MyBean();
        }
    }

    @Configuration
    @BooleanConditional(false)
    static class Config2{
        @Bean
        MyBean  myBean(){
            return new MyBean();
        }
    }

    static class MyBean{}


    //목표 : 어노테이션에 value를 설정하고 어노테잇녀에 벨류에 맞게 이 빈을 불러올지 말지 정할 수 있음
    static class BooleanCondition implements Condition {

        @Override
        //metadata 파라미터를 통해 어노테이션에 파라미터로 전달되어 있는 파라미터값을 가지고 온다.
        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
            //AnnotaionTypeMetaData를 통해서 어노테이션의 어트리뷰트를 챙길 수 있으
            Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes(BooleanConditional .class.getName());
            Boolean value = (Boolean) annotationAttributes.get("value");
            return value;
        }
    }

    static class FalseCondition implements Condition {

        @Override
        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
            return false;
        }
    }


}
