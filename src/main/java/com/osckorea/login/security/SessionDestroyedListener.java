package com.osckorea.login.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.security.core.session.SessionDestroyedEvent;
import org.springframework.stereotype.Component;


/**
 * Created by jslim
 */
@Slf4j
@Component
public class SessionDestroyedListener implements ApplicationListener<SessionDestroyedEvent> {
    @Override
    public void onApplicationEvent(SessionDestroyedEvent sessionDestroyedListener) {
        log.info("세션끊김");
    }
}
