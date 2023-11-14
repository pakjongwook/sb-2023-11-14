package com.ll.sb20231114;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/calc") //http://localhost:8020/calc?a=10&b=20
    @ResponseBody
    String showCalc(int a, int b){ // 안됨 : int(primitive type) : null 허용 X
        return "계산 결과 : %d".formatted(a + b);
    }
    @GetMapping("/calc2") // http://localhost:8020/calc2?a=10&b=20
    @ResponseBody
    String showCalc2(Integer a, Integer b){ // Integer : null 허용됨
        return "a :" + a + "b :" + b;
    }
    @GetMapping("/calc3") // http://localhost:8020/calc3?a=10&b=20
    @ResponseBody
    String showCalc3(
            @RequestParam(defaultValue = "0") int a, 
            // 클라이언트가 전달하는 쿼리 파라미터를 서버에서 처리할 수 있게 해주는 어노테이션
            @RequestParam(defaultValue = "0") int b
    ) {
        return "계산 결과 : %d".formatted(a + b);
    }
    @GetMapping("/calc4")
    @ResponseBody
    String showCalc4(
            @RequestParam(defaultValue = "0") double a,
            @RequestParam(defaultValue = "0") double b
    ) {
        return "계산 결과 : %f".formatted(a + b);
    }

    @GetMapping("/calc5")
    @ResponseBody
    String showCalc4(
            @RequestParam(defaultValue = "-") String a,
            @RequestParam(defaultValue = "-") String b
    ) {
        return "계산 결과 : %s".formatted(a + b);
    }
}
