package isntkyu.core;

import isntkyu.core.discount.DiscountPolicy;
import isntkyu.core.discount.FixDiscountPolicy;
import isntkyu.core.discount.RateDiscountPolicy;
import isntkyu.core.member.MemberRepository;
import isntkyu.core.member.MemberService;
import isntkyu.core.member.MemberServiceImpl;
import isntkyu.core.member.MemoryMemberRepository;
import isntkyu.core.order.OrderService;
import isntkyu.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService () {
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    private DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
