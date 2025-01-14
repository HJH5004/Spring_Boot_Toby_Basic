package tobyspringboot.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;

@HelloBootTest
public class JdbcTempleteTest {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @BeforeEach
    void init(){
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS MEMBER(NAME VARCHAR(50) PRIMARY KEY, COUNT INT)");
    }


    @Test
    void insetANdQuery(){
        jdbcTemplate.update("INSERT INTO MEMBER VALUES (?, ?) ", "JAKE", 10);
        jdbcTemplate.update("INSERT INTO MEMBER VALUES (?, ?) ", "HONG", 99);

        Long count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM MEMBER", Long.class);
        Assertions.assertThat(count).isEqualTo(2);
    }
}
