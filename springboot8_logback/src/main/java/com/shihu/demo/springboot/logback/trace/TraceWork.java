package com.shihu.demo.springboot.logback.trace;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class TraceWork {
    private static final Logger LOGGER = LoggerFactory.getLogger(TraceWork.class);
    public void work(){
        LOGGER.trace("This level is TRACE.");
        LOGGER.debug("This level is DEBUG.");
        LOGGER.info("This level is INFO.");
        LOGGER.warn("This level is WARN.");
        LOGGER.error("This level is ERROR.");
        System.out.println("-----------------------------------------------------------------");
    }
}
