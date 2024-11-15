package kr.or.ddit.case02.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;

@Controller
@Slf4j
@RequestMapping("/case02")
public class ReceiveCookieController {

    @RequestMapping("cookie3")
    public void handler3(@CookieValue Cookie cookie) {
        log.info("cookie : {}", cookie);
    }

    @RequestMapping("cookie2")
    public void handler2(@CookieValue String cookie) {
        log.info("cookie value : {}", cookie);
    }

    @RequestMapping("cookie1")
    public void handler1(@RequestHeader String cookie) {
        log.info("cookie header : {}", cookie);

    }
}
