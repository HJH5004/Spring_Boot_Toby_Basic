package tobyspringboot.config;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.MultiValueMap;

public class MyConfigurationPropertiesImportSelector implements DeferredImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        //이 어노테이션에 붙어있는 모든 어트리ㅂ트를 가지고 온다.
        MultiValueMap<String, Object> attrs = importingClassMetadata.getAllAnnotationAttributes(EnableMyConfigurationProperties.class.getName());
        Class property = (Class) attrs.getFirst("value");

        return new String[]{property.getName()};
    }
}
