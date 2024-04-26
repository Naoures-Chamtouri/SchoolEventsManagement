package project.example.school.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import project.example.school.Track;

import java.util.Date;

@Aspect
@Component
public class AspectAnnotation {

        @Pointcut("@annotation(secured)")
        public void callAt(Track secured) {
        }

        @Around("callAt(secured)")
        public Object around(ProceedingJoinPoint pjp,
                             Track secured) throws Throwable {
            System.out.println("\033[0;34m"+"Request to "+" Permissible "+"\033[0m");
            return secured.isLocked() ? null : pjp.proceed();
        }

}
