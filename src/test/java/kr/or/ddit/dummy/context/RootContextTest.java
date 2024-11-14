package kr.or.ddit.dummy.context;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

@SpringJUnitWebConfig(locations = "file:src/main/resources/kr/or/ddit/spring/context-*.xml")
public class RootContextTest {

    @Test
    public void testRootContext() {

    }
}
