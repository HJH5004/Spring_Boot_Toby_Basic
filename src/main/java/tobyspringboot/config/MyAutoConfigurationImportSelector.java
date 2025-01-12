package tobyspringboot.config;

import org.springframework.boot.context.annotation.ImportCandidates;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.List;

public class MyAutoConfigurationImportSelector implements DeferredImportSelector {

    private final ClassLoader classloader;

    public MyAutoConfigurationImportSelector(ClassLoader classloader){
        this.classloader = classloader;
    }

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        //Plan A. Stream을 활용한 interrate 처리/
//        Iterable<String> candidate = ImportCandidates.load(MyAutoConfiguration.class, classloader);
//        return StreamSupport.stream(candidate.spliterator(), false).toArray(String[]::new);

        //Plan B. 단순한 for문을 활용한 itnerrate 처리
        List<String> autoConfigs = new ArrayList<>();
        ImportCandidates.load(MyAutoConfiguration.class, classloader).forEach(autoConfigs :: add );
        return autoConfigs.toArray(new String[0]);


        // Plan B. 하드코딩을 통한 방안
//        return new String[]{
//            "tobyspringboot.config.autoConfig.DispatcherServletConfig",
//            "tobyspringboot.config.autoConfig.TomcatWebServerConfig"
//        };
    }
}
