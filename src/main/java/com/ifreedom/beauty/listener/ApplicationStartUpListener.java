package com.ifreedom.beauty.listener;

import com.ifreedom.beauty.util.PropertyUtil;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @atuhor:eavawu
 * @date:4/29/16
 * @todo:
 */
public class ApplicationStartUpListener implements ApplicationListener<ApplicationStartedEvent> {


    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        PropertyUtil.loadAllProperties();
        System.out.println("ApplicationStartUpListener EXEC");
    }
}
