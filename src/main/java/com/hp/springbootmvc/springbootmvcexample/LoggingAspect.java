package com.hp.springbootmvc.springbootmvcexample;
import java.util.List;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect
{

    private static final Logger LOGGER= LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(public * com.hp.springbootmvc.springbootmvcexample.alienController.get_all_aliens())")
    public void logBefore()
    {
        LOGGER.info("getAliens method called");
    }

    @After("execution(public * com.hp.springbootmvc.springbootmvcexample.alienController.get_all_aliens())")
    public void logAfter()
    {
        LOGGER.info("getAliens method called");
    }
}
