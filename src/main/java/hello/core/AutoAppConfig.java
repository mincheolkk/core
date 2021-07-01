package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
//        basePackages = "hello.core.member", // 설정해주지 않으면 AutoAppConfig 가 포함된 패키지(여기선 hello.core)
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        //@Configuration 이 붙은 예제 코드를 살리기 위해서 예외설정
)
public class AutoAppConfig {

}
