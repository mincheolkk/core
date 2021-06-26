package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        //appConfig에서 memberService() 를 달라그러면 MemberServiceImpl 을 만들고 거기에 MemoryMemberRepository 를 사용할거라고 주입해줌

//        MemberService memberService = new MemberServiceImpl(); // AppConfig 생성전에는 MemberServiceImpl을 메인 메서드에서 직접 생성해줌

        Member member = new Member(1L, "memberA", Grade.VIP); // id는 1임 . Long 타입이니까 뒤에 L 붙혀준 것. 안 붙히면 오류.
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
    }
}
