package kr.or.ddit.mbti.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.*;

//여기는 개발영역이라서 클래스패스쓰면안됨
@Slf4j
@SpringJUnitWebConfig(locations = "file:src/main/resources/kr/or/ddit/spring/context-*.xml")
class MbtiServiceImplTest {

    @Inject
    MbtiService service;

    @Test
    void createMbti() {
    }

    @Test
    void readMbti() {
    }

    @Test
    void readMbtiList() {

        assertDoesNotThrow(() -> service.readMbtiList());
    }


    @Test
    void modifyMbti() {
    }

    @Test
    void removeMbti() {
    }
}