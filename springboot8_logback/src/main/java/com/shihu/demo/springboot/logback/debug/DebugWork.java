package com.shihu.demo.springboot.logback.debug;

import com.shihu.demo.springboot.union.aop.annotation.WorkingTimeAnnotation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DebugWork {
    private static final Logger LOGGER = LoggerFactory.getLogger(DebugWork.class);
    @WorkingTimeAnnotation
    public void work(){
        LOGGER.trace("This level is TRACE.");
        LOGGER.debug("This level is DEBUG.");
        LOGGER.info("This level is INFO.");
        LOGGER.warn("This level is WARN.");
        LOGGER.error("This level is ERROR.");
        System.out.println("-----------------------------------------------------------------");
    }
}
