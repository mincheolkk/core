package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;


public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;
    //final 이 나오면 기본으로 할당, 또는 생성자를 통해서 할당을 해야함
    //MemberRepositoy 와 DiscountPolicy 의존

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice); //OrderService 입장에서는 할인에 대한건 모름. 잘 만든 설계

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
