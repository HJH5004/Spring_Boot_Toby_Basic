package tobyspringboot.helloboot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class HelloApiTest {
    @Test
    void helloAPi() {
        //
        TestRestTemplate restTemplate = new TestRestTemplate();

        ResponseEntity<String> res =
                restTemplate.getForEntity("http://localhost:9090/app/hello?name={name}",String.class,"Spring");

        //검증
        // 상태 코드
        org.assertj.core.api.Assertions.assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);
        // 헤더
        assertThat(res.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE)).startsWith(MediaType.TEXT_PLAIN_VALUE);
        // hello spring
        assertThat(res.getBody()).isEqualTo("*Hello Spring*");
    }

    @Test
    void failHelloAPi() {
        //
        TestRestTemplate restTemplate = new TestRestTemplate();

        ResponseEntity<String> res =
                restTemplate.getForEntity("http://localhost:9090/app/hello?name=",String.class);

        //검증
        // 상태 코드
        org.assertj.core.api.Assertions.assertThat(res.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
