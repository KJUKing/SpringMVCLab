package kr.or.ddit.case03.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/case03")
public class Model2Controller {

    @RequestMapping("tiles")
    public String handle2() {
        return "case03/dummyContent";
    }

    @RequestMapping("singleJsp")
    public String handle1() {
        return "/case03/single";
    }
}
