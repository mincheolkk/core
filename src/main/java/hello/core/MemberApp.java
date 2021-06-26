package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP); // id는 1임 . Long 타입이니까 뒤에 L 붙혀준 것. 안 붙히면 오류.
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
    }
}
