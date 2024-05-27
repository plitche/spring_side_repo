package hello.core.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StateFulServiceTest {

    @Test
    void statefulServiceSingleton() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
        StateFulService bean1 = ac.getBean(StateFulService.class);
        StateFulService bean2 = ac.getBean(StateFulService.class);

        // ThreadA : A사용자가 10000원 주문
        // bean1.order("userA", 10000);

        // ThreadB : B사용자가 20000원 주문
        // bean1.order("userB", 20000);


        // ThreadA : 사용자A 주문 금액 조회
        // int price = bean1.getPrice();
        // System.out.println("price = " + price);

        // org.assertj.core.api.Assertions.assertThat(bean1.getPrice()).isEqualTo(20000);

        // 무상태
        int userA = bean1.order("userA", 10000);
        int userB = bean1.order("userB", 20000);
        System.out.println("userA = " + userA);
        System.out.println("userB = " + userB);

        // org.assertj.core.api.Assertions.assertThat(bean1.getPrice()).isEqualTo(20000);
    }

    static class TestConfig {
        @Bean
        public StateFulService stateFulService() {
            return new StateFulService();
        }
    }

}
