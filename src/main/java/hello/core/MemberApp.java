package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class); // AppConfig 에 있는 환경설정 정보를 가지고 스프링이 AppConfig 에 @Bean  붙은 애들을 객체로 스프링 컨테이너에서 관리해줌
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        /* AppConfig 에서 스프링 컨테이너에 이름으로 등록된  "memberService" 객체를 찾음.
        key는 이름 이고 value는 객체 인스턴스로 스프링 컨테이너에 등록.
         MemberService.class 는 타입.
         스프링 컨테이너에서 꺼낼때는 이름과 타입 주고 꺼냄냄         */


        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
    }
}
