package project.example.school.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class TimeInterceptor {
    @After(value="execution(* project.example.school.controller.eventController.*(..))")
    public void afterAddingEvent(JoinPoint joinPoint){

        System.out.println("\033[0;34m"+"Request 22 to "+joinPoint.getSignature()+" ended at "+new Date() + "\033[0m");
    }
}
