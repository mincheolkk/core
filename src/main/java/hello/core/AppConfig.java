package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;


public class AppConfig  {

//    public MemberService memberService() {
//        return new MemberServiceImpl(new MemoryMemberRepository()); // 생성자를 통해서 객체가 들어감 (생성자 주입)
//    }
    /** 구현체인 MemoryMemberRepository 에선 MemberRepository 라는 역할이 잘 안 보임. 아래처럼 리팩토링 **/
    
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

     public DiscountPolicy discountPolicy() {
         return new FixDiscountPolicy();
//         return new RateDiscountPolicy();
     }

    /**
    이제는 MemberServiceImpl 과  OrderServiceImpl 을 AppConfig 에서 생성
    **/
}
