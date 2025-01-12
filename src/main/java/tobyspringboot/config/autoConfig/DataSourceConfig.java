package tobyspringboot.config.autoConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import tobyspringboot.config.ConditionalMyOnClass;
import tobyspringboot.config.MyAutoConfiguration;

import javax.sql.DataSource;

@MyAutoConfiguration
@ConditionalMyOnClass("org.springframework.jdbc.core.JdbcOperations")
public class DataSourceConfig {
    @Bean
    DataSource dataSource(){
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();

        dataSource.

        return dataSource;
    }
}
