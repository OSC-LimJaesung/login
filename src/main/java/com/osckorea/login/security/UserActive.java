package com.osckorea.login.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;


/**
 * Created by jslim
 */
@Component
@Slf4j
public class UserActive implements HttpSessionBindingListener {

    @Override
    public void valueBound(HttpSessionBindingEvent event){
        log.info("log in : {} ", event.getName());
    }
    @Override
    public void valueUnbound(HttpSessionBindingEvent event){
        log.info("log out : {} ", event.getName());
    }

}
