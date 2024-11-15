package kr.or.ddit.case02.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/case02")
public class ReceiveRequestHeaderController {

    @RequestMapping("header7")
    public void handler7(@RequestHeader(name = "num-header") Optional<Integer> numHeader) {
        log.info("num-header: {}", numHeader.orElse(-1));
    }

    @RequestMapping("header6")
    public void handler6(@RequestHeader(name = "num-header", required = false, defaultValue = "-1") int numHeader) {
        log.info("num-header: {}", numHeader);
    }

    @RequestMapping("header5")
    public void handler5(@RequestHeader(name = "user-agent", required = false) String userAgent) {
        log.info("user-agent: {}", userAgent);
    }

    @RequestMapping("header4")
    public void handler4(@RequestHeader HttpHeaders headers) {
        headers.forEach((key, value) -> {
            log.info("key: {}, value: {}", key, value);
        });
    }

    @RequestMapping("header3")
    public void handler3(@RequestHeader MultiValueMap<String, String> headers) {
        headers.forEach((key, value) -> {
            log.info("key: {}, value: {}", key, value);
        });
    }
    @RequestMapping("header2")
    public void handler2(@RequestHeader Map<String, ?> headers) {
        headers.forEach((key, value) -> {
            log.info("key: {}, value: {}", key, value);
        });
    }

    @RequestMapping("header1")
    public void header1(HttpServletRequest req) {
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            Enumeration<String> headers = req.getHeaders(name);
            while (headers.hasMoreElements()) {
                String value = headers.nextElement();
                log.info(" {} : {} ", name,value);
            }
        }
    }
}
