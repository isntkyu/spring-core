package isntkyu.core.discount;

import isntkyu.core.member.Grade;
import isntkyu.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("vip는 10퍼할인이 적용되어야한다.")
    void vip_o (){
        Member member = new Member(1L, "memberA", Grade.VIP);

        int discount = rateDiscountPolicy.discount(member, 10000);

        Assertions.assertThat(discount).isEqualTo(1000);

    }

    @Test
    @DisplayName("vip만 10퍼할인이 적용되어야한다.")
    void vip_x (){
        Member member = new Member(2L, "memberB", Grade.BASIC);

        int discount = rateDiscountPolicy.discount(member, 10000);

        Assertions.assertThat(discount).isEqualTo(0);

    }

}