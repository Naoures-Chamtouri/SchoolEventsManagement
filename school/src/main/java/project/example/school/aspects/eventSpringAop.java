package project.example.school.aspects;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.apache.hc.client5.http.auth.AuthenticationException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import project.example.school.model.Event;
import project.example.school.service.schoolService;

import java.util.Date;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.aop.Pointcut;
//import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class eventSpringAop {
    private static final Logger log = LoggerFactory.getLogger(eventSpringAop.class);
    private final schoolService service;
    @Autowired
    HttpServletRequest request;



    @Before(value="execution(* project.example.school.controller.eventController.*(..))")
    public void beforeAddingEvent(JoinPoint joinPoint){

        System.out.println("\033[0;34m"+"Request to "+joinPoint.getSignature()+" started at "+new Date() + "\033[0m");
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void postMapping() {}



 //   @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping) && args(requestBody, ..)")
    @Pointcut(value="execution(* project.example.school.controller.eventController.save(..)) && args(requestBody,..)")
    public void postMappingWithRequestBody(Object requestBody) {}

    @Around("postMappingWithRequestBody(requestBody)")
    public Object logPostRequestBody(ProceedingJoinPoint joinPoint, Object requestBody) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        Class clazz = joinPoint.getTarget().getClass();
        Logger logger = LoggerFactory.getLogger(clazz);
        logger.info("Save Event Request AOP Security Testing Start");
        String requesttext= String.valueOf(request.getRequestURL());
        String[] parts = requesttext.split("/");
        String author =parts[parts.length - 1];
        logger.info("Request body: {}", requestBody);
        logger.info("Author sending request : {}", author);
        //System.out.println("params: " + params);
        Event event = (Event) requestBody;

        String manager =service.getSchoolManager(event.getSchool().getSchoolId());
        System.out.println("manager "+manager);
        if(author.equals(manager)) {
            System.out.println("\033[0;34m"+"Author Verification Succeeded"+ "\033[0m");
         return joinPoint.proceed();
        }
        else {
            System.out.println("Author Verification Failed");
           // throw new SecurityException("Author Verification Failed");
            logger.info("Author Verification Failed");

            throw new AuthenticationException("Unauthorized access");
        }
    }

    private static final int MAX_RETRIES = 3;
    private static final long BACKOFF_DELAY = 1000; // in milliseconds

    @Pointcut("execution(* project.example.school.controller.eventController.save(..))")
    public void httpRequest() {}

    @AfterThrowing(pointcut = "httpRequest()", throwing = "ex")
    public void retryHttpRequest(Exception ex) throws Exception {
        int retries = 0;
        System.out.println("\033[0;34m"+"Request Retrying"+"\033[0m");
        while (retries < MAX_RETRIES) {
            try {
                // Add your HTTP GET request logic here
                // Example using RestTemplate:
                RestTemplate restTemplate = new RestTemplate();
                String result = restTemplate.getForObject("http://localhost:8071/api/schools/events", String.class);

                // If the request succeeds, exit the retry loop
                return;
            } catch (Exception e) {
                // If the request fails, log the error and wait before retrying
                System.err.println("HTTP GET request failed: " + e.getMessage());
                Thread.sleep(BACKOFF_DELAY);
                retries++;
            }
        }
        // If maximum retries reached, rethrow the original exception
        throw ex;
    }



    // Measure method execution time
    @Around("execution(*  project.example.school.controller.*.*(..))")
    public Object measureMethodExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        System.out.println("\033[0;34m"+"Method " + proceedingJoinPoint.getSignature() + " executed in " + executionTime + " ms"+"\033[0m");
        return result;
    }






}
