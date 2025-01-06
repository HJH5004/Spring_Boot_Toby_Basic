package tobyspringboot.helloboot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class HelloApiTest {
    @Test
    void helloAPi() {
        //
        TestRestTemplate restTemplate = new TestRestTemplate();

        ResponseEntity<String> res =
                restTemplate.getForEntity("http://localhost:8080/hello?name={name}",String.class,"Spring");

        //검증
        // 상태 코드
//        Asser
        // 헤더
        // hello spring
    }
}
