package tobyspringboot.helloboot;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension; 
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes =  TobySpringBootApplication.class)
@TestPropertySource("classpath:/application.properties")
/*
 * 이 어노테이션의 목적
 *   - 테스트 코드에서 DB 관련 테스트 코드를 생성할 때 테스트 코드에서 insert된 값이 실제 DB에 반영되지 않도록 막아주는 어노테이션
 * 개요
 *   - 테스트 코드에서 작성되어 쿼리문을 수행할 떄 테스트가 완료되거나 실패되면 DB를 원래 기존의 상태로 되돌리는 어노테이션
 *   - 테스트 1개 단위가 끝날 떄 마다 롤백 해준다. 테스트 class 안에 N개의 테스트가 있다면 n 번 RollBack 한다.
 * */
@Transactional
public @interface HelloBootTest {
}
