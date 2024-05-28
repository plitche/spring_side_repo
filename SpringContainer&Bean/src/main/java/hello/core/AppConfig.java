package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepositoryImpl;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// @Configuration 을 붙이지 않아도 모두 Bean으로 등록 되지만,
// CGLIB 클래스가 아닌 AppConfig 자체가 빈으로 등록된다.
// 또한 아래 memberRepository가 3번 호출된다.
@Configuration
public class AppConfig {

    //@Bean memberService -> new MemberRepositoryImpl();
    //@Bean orderService -> new MemberRepositoryImpl();


    // 예상
    // AppConfig.memberService
    // AppConfig.memberRepository
    // AppConfig.memberRepository
    // AppConfig.orderService
    // AppConfig.memberRepository

    // 결과
    // AppConfig.memberService
    // AppConfig.memberRepository
    // AppConfig.orderService

    @Bean
    public MemberService memberService() {
        System.out.println("AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepositoryImpl memberRepository() {
        System.out.println("AppConfig.memberRepository");
        return new MemberRepositoryImpl();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}

/**
*   1 SRP : 단일 책임 원칙
*      - 한 클래스는 하나의 책임만 가져야 한다.
*   2 DIP : 의존관계 역전 원칙
*      - 프로그래머는 추상화에 의존해야지, 구체화에 의존하면 안된다.
*      - 의존성 주입은 이 원칙을 따르는 방법 중 하나다.
*   3 OCP
*      - 소프트웨어 요소는 확장에는 열려있으나 변경에는 닫혀 있어야 한다.
*/
