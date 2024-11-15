package kr.or.ddit.case01.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/case01/headerMapping")
public class HttpRequestHeaderMappingController {

    @RequestMapping(headers = "myheader=headervalue")
    public void handler1() {
        log.info("myheader=headervalue 조건 일치함 hendler 1 동작");
    }

    @RequestMapping(headers = "myheader!=headervalue")
    public void handler2() {
        log.info("myheader 조건 일치함 hendler 2 동작");
    }


}
