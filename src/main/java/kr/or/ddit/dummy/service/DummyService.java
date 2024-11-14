package kr.or.ddit.dummy.service;


import kr.or.ddit.dummy.dao.DummyDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Slf4j
@Service
@RequiredArgsConstructor
public class DummyService {


    private final DummyDao dao;

    @PostConstruct
    public void init(){
        log.info("주입된 dao: {}", dao);
    }

}
