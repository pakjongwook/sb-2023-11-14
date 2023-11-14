package com.ll.sb20231114;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // 어노테이션 == 주석
public class HomeController { // Controller : 은행 창고 직원 역할

    @GetMapping("/")
    @ResponseBody // 이 함수의 리턴값을 그대로 브라우저에 출력하라는 의미
    String showMain(){
        return "안녕하세요";
    }
    @GetMapping("/about")
    @ResponseBody
    String showAbout(){
        return "개발자 커뮤니티";
    }
}
