package hello.core.scan.filter;


import java.lang.annotation.*;

@Target(ElementType.TYPE) //TYPE 이라 지정했으니 CLASS 레벨에 붙음
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponet {
}
