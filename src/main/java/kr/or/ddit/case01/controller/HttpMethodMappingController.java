package kr.or.ddit.case01.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/case01/methodMapping")
public class HttpMethodMappingController {


    @GetMapping
    public void handler1() {
        log.info("Get에 해당하는 handler 1번 동작");
    }

    @PostMapping
    public void handler2() {
        log.info("Post에 해당하는 handler 2번 동작");
    }

    @RequestMapping
    public void handler3() {
        log.info("기타 메소드에 해당하는 handler 3번 동작");
    }
}
