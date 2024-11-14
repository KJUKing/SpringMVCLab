package kr.or.ddit.dummy.controller;


import kr.or.ddit.dummy.service.DummyService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;


@Slf4j
@Controller
public class DummyController {

    @Autowired
    private DummyService service;

    @PostConstruct
    public void init(){
        log.info("주입된 서비스 : {}",service);
    }
}
