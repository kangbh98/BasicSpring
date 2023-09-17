package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class SingleTonTest {


    @Test
    @DisplayName("스프링 없는 순수한 컨테이너")
    void pureContainer() {

        AppConfig appConfig = new AppConfig();

        // 1. 조회: 호출할 떄마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();

        // 1. 조회: 호출할 떄마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();

        // 참조 값이 다른것을 확인
        System.out.println("memberService2 = " + memberService2);

        System.out.println("memberService1 = " + memberService1);

        Assertions.assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("싱글톤 패턴 객체 사용")
    void singleTondServiceTest() {
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        Assertions.assertThat(singletonService1).isSameAs(singletonService2);
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer(){

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);


        // 1. 조회: 호출할 떄마다 객체를 생성
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        // 참조 값이 다른것을 확인
        System.out.println("memberService2 = " + memberService2);

        System.out.println("memberService1 = " + memberService1);

        Assertions.assertThat(memberService1).isSameAs(memberService2);
    }
}