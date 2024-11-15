package kr.or.ddit.case01.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.http.MediaType.*;

//GET요청 수집 json응답요청 xml응답요청 요청이외의 요청은 406 에러전송
//POST요청 수집 (request parameter수집, 이외 요청은 415 에러
//myheader가 포함된 요청만 수집함
//
@RequestMapping(value = "/case01/mission", headers = "my-header")
@Slf4j
@Controller
public class Case01MissionController {

    @GetMapping(produces = {APPLICATION_XML_VALUE, APPLICATION_JSON_VALUE})
    public void handler1() {
        log.info("handler1 XML이나 JSON 요청받아들임");
    }

    @PostMapping(consumes = APPLICATION_FORM_URLENCODED_VALUE)
    public void handler3() {
        log.info("handel3 폼데이터 받음");
    }
}
