package hello.core.member;

public class MemberServiceImpl implements MemberService {

    // private final MemberRepository memberRepository = new MemoryMemberRepository();
    /** 인터페이스와 구현체 모두에 의존하는 문제가 있음(추상화에도 의존하고 구체화에도 의존)
     이젠 추상화에만 의존 , 구체적인것은 AppConfig 에서 결정 (아래 코드) */

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    } // 생성자를 통해서 memberRepositoty 에 어떤 구현체가 들어갈지 생성자를 통해서 결정

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}