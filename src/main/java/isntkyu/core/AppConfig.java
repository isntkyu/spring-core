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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService () {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
