package isntkyu.core;

import isntkyu.core.Order.Order;
import isntkyu.core.Order.OrderService;
import isntkyu.core.Order.OrderServiceImpl;
import isntkyu.core.member.Grade;
import isntkyu.core.member.Member;
import isntkyu.core.member.MemberService;
import isntkyu.core.member.MemberServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = "+ order.calculatePrice());
    }
}
