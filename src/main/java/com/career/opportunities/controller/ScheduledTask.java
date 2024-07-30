package com.career.opportunities.controller;

import io.quarkus.scheduler.Scheduled;
import java.util.logging.Logger;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ScheduledTask{

    private static final Logger LOGGER = Logger.getLogger(ScheduledTask.class.getName());

    @Scheduled(every="5s")
    void periodicTask(){
        LOGGER.info("Periodic task executed at " + System.currentTimeMillis());
    }
}
