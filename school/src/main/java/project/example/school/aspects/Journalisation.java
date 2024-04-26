package project.example.school.aspects;

import org.aopalliance.intercept.Interceptor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Aspect
@ConfigurationProperties("interceptor")
@Component
public class Journalisation {

    private static final Logger logger = LoggerFactory.getLogger(Interceptor.class);

    private String message = "Startup";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Around("execution(* project.example.school.controller.eventController.*(..)) && within(project.example.school..*)")
    public Object intercept(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = joinPoint.proceed();
        logger.info("Journal interception: " + joinPoint.toShortString() + ": " + result);


        return result;
    }

    @Around("execution(* project.example.school.controller.eventController.*(..)) && within(project.example.school..*)")
    public Object another(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = joinPoint.proceed();
        logger.info("AspectJ another: " + joinPoint.toShortString() + ": " + result);
        return result;
    }


}