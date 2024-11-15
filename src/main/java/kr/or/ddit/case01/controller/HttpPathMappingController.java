package kr.or.ddit.case01.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/case01")
public class HttpPathMappingController {

    @GetMapping("path1")
    public void handler1() {
        log.info("path1번의 handler1번 동작");
    }

    @GetMapping("path2/{type}/info")
    public void handler2(@PathVariable(required = false) String type) {
        log.info("path2번의 handler2번 동작, 경로변수 {}", type);
    }
}
