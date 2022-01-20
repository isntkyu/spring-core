package isntkyu.core.Order;

import isntkyu.core.discount.DiscountPolicy;
import isntkyu.core.discount.FixDiscountPolicy;
import isntkyu.core.member.Member;
import isntkyu.core.member.MemberRepository;
import isntkyu.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
