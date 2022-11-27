package com.yet.spring.core;

import com.yet.spring.core.beans.Client;
import com.yet.spring.core.beans.Event;
import com.yet.spring.core.beans.EventType;
import com.yet.spring.core.loggers.DBLogger;
import com.yet.spring.core.loggers.EventLogger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;


public class App {
    private Client client;
    private EventLogger defaultLogger;
    private Map<EventType, EventLogger> loggers;
    
    public App(Client client, EventLogger eventLogger, Map<EventType, EventLogger> loggers) {
        super();
        this.client = client;
        this.defaultLogger = eventLogger;
        this.loggers = loggers;
    }
    
    public App() {
    }
    
    
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext(
            "spring.xml",
            "loggers.xml",
            "aspects.xml",
            "db.xml");
        
        App app = (App) ctx.getBean("app");
        app.logEvents(ctx);
    }
    
    private void logEvent(EventType eventType, Event event, String msg) {
        EventLogger logger = loggers.get(eventType);
        if (logger == null) {
            logger = defaultLogger;
        }
        event.setMsg(msg);
        logger.logEvent(event);
    }
    
    public void logEvents(ApplicationContext ctx) {
        Event event = ctx.getBean(Event.class);
        logEvent(EventType.INFO, event, "Some event for 1");
        
        event = ctx.getBean(Event.class);
        logEvent(EventType.INFO, event, "One more event for 1");
        
        event = ctx.getBean(Event.class);
        logEvent(EventType.WARNING, event, "Some WARN event for 3");
        
        event = ctx.getBean(Event.class);
        logEvent(EventType.WARNING, event, "Some WARN event for 3");
        
        event = ctx.getBean(Event.class);
        logEvent(EventType.WARNING, event, "Some WARN event for 3");
    }
    
    public EventLogger getDefaultLogger() {
        return defaultLogger;
    }
}
