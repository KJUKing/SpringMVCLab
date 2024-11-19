package kr.or.ddit.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.util.Properties;

@Slf4j
@Component
public class CustomContextRefreshEventListener {

    @Inject
    @Named("dirInfo")
    private Properties dirInfo;

    @EventListener(ContextRefreshedEvent.class)
    public void eventListener(ContextRefreshedEvent event ) throws IOException {
        ApplicationContext container = event.getApplicationContext();
        for (Object key : dirInfo.keySet()) {
            String keyStr = key.toString();
            String value = dirInfo.getProperty(keyStr);
            Resource dirRes = container.getResource(value);
            log.info("저장 경로 확인 : {} - {}", key, dirRes);
            if (!dirRes.exists()) {
                dirRes.getFile().mkdir();
            }
        }
    }
}
