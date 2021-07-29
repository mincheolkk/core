package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
    private final MyLogger myLogger;
    // Mylogger 의 생존범위는 request 가 들어와서 나갈때까지
    // 스프링 컨테이너가 뜨는 시점에는 request 가 없으므로 MyLogger 가 없음 .



    @RequestMapping("log-demo")
    @ResponseBody // 문자열을 그대로 보낼 수 있음 .
    public String logDemo(HttpServletRequest request) {
        String requestURL = request.getRequestURL().toString();
        myLogger.setRequestURL(requestURL);

        myLogger.log("controller test");
        logDemoService.logic("testId");
        return "ok";
    }
}
