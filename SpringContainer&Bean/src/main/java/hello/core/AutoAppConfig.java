package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        // 컴포넌트 스캔 대상 시작 패키지 지정
        basePackages = "hello.core.member",
        basePackageClasses = AutoAppConfig.class,
        // Bean에 등록할 클래스를 제외하는 방법
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
}



//* 컴포넌트 스캔과 의존관계 자동 주입 시작하기
//- 지금까지 스프링 빈을 등록할 때는 자바 코드의 @#Bean이나 등등을 통해 설정 정보에 직접 등록할 스프링 빈을 나열했다.
//- 하지만 스프링 빈이 많아지면 일일이 등록하기도 힘들고 누락하는 문제도 발생한다.
//- 그래서 스프링은 설정 정보가 없어도 자동으로 스프링 빈을 등록하는 컴포넌트 스캔이라는 기능을 제공한다.
//- 또 의존관계도 자동으로 주입하는 @Autowired 라는 기능도 제공한다.

/*
* 탐색할 패키지의 시작 위치 지정
        - 모든 자바 클래스를 다 컴포넌트 스캔하면 시간이 오래 걸린다.
        - 그래서 필요한 위치부터 탐색하도록 지정할 수 있다.

@ComponentScan(
        basePackage = "hello.core"
)

* 컴포넌트 스캔 기본 대상
   - @Component
   - @Controller
   - @Service
   - @Repository
   - @Configuration

*/

