package kr.or.ddit.case1.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@Controller
public class RegistController {

    @RequestMapping("/case01/request04")
    public void handler04_1(){
        log.info("/case01/request04 요청 접수");
    }

    @PostMapping("/case01/request04")
    public void handler04(){
        log.info("/case01/request04 요청 접수");
    }

    @PutMapping("/case01/request03")
    public void handler03(){
        log.info("/case01/request03 요청 접수");
    }

    @RequestMapping(value = "/case01/request02", method = {RequestMethod.GET, RequestMethod.POST})
    public void handler02(){
        log.info("/case01/request02 요청 접수");
    }

    @RequestMapping("/case01/request01")
    public void handler01(){
      log.info("/case01/request01 요청 접수");
    }
}
