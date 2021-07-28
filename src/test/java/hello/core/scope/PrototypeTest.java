package hello.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class PrototypeTest {

    @Test
    void prototypeBeanFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);

        System.out.println("find prototypeBean1");
        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
        System.out.println("find prototypeBean2");
        PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);

        System.out.println("prototypeBean1 = " + prototypeBean1);
        System.out.println("prototypeBean2 = " + prototypeBean2);
        Assertions.assertThat(prototypeBean1).isNotSameAs(prototypeBean2);

        ac.close();
        // prototype 이기에 close 안 됨 .
        // prototypeBean 은, 스프링 컨테이너가 생성과 의존관계 주입, 초기화 까지만 관여하고 관리 안함 .
        // 즉, 스프링 컨테이너가 종료될때, @PreDestroy 같은 종료 메서드가 전혀 실행되지 않음 .
        // prototypeBean 을 닫고자 하면 아래와 같이 직접 호춣해야 함 .

        prototypeBean1.destroy();
        prototypeBean2.destroy();
    }

    @Scope("prototype")
    // 위의 prototypeBeanFind 메소드에서 AnnotationConfigApplicationContext(PrototypeBean) 을 넣기에 componentscan 을 안해줘도 됨 .
    static class PrototypeBean {

        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean.init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("PrototypeBean.destroy");
        }

    }

}
