package isntkyu.core.discount;

import isntkyu.core.member.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);
}
