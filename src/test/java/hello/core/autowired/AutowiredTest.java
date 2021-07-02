package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean {

        @Autowired(required = false) //required 가 false면 의존관계가 없을 때, 메서드 자체가 아에 호출이 안됨.
        public void setNoBean1(Member noBean1) { //Member는 스프링 컨테이너가 관리하는 상태가 아님. 테스트를 위해 관리상태 아닌 것 중 임의로 선택
            System.out.println("noBean1 = " + noBean1);
        }

        @Autowired
        public void setNoBean2(@Nullable Member noBean2) { //Nullable 은 호출은 되는데, Null 로 들어옴
            System.out.println("noBean2 = " + noBean2);
        }

        @Autowired
        public void setNoBean3(Optional<Member> noBean3) { //Optional 문법, 값이 없으면 Optional.empty 로 출력
            System.out.println("noBean3 = " + noBean3);
        }
    }
}
