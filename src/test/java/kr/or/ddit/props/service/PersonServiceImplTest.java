package kr.or.ddit.props.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitWebConfig(locations = "file:src/main/resources/kr/or/ddit/spring/context-*.xml")
class PersonServiceImplTest {


    @Autowired
    PersonService service;

    @Test
    void createPerson() {
    }

    @Test
    void readPerson() {
    }

    @Test
    void readPersonList() {
        assertDoesNotThrow(() ->service.readPersonList());
    }

    @Test
    void modifyPerson() {
    }

    @Test
    void removePerson() {
    }
}