package kr.or.ddit.case01.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequestMapping("/case01/acceptContentType")
@Controller
public class RequestAcceptContentTypeMappingController {

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void handler3() {
        log.info("Request body가 json인 경우 handler 3번 동작");
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public void handler1() {
        log.info("request accpet header [application/json] 인 경우 handler 1번동작");
    }

    @GetMapping
    public void handler2() {
        log.info("URI 매핑인 경우 handler 2번동작");
    }
}
