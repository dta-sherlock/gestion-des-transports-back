package dev.listeners;

import dev.services.DataInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StartUpAppListener {

    @Autowired
    private DataInitService initService;

    @EventListener(ContextRefreshedEvent.class)
    public void contextRefreshedEvent() {
        // initialize DB at the application start up
        initService.init();
    }
}
