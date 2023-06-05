package miu.edu.lab1.aspect;

import jakarta.transaction.Transactional;
import miu.edu.lab1.domain.Logger;
import miu.edu.lab1.domain.Users;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Aspect
@Transactional
public class LoggerAspect {

    @Pointcut("execution( * miu.edu.lab1.controller.UserController.*(..))")
    public void logMe(){

    }



    @Before("logMe()")
    public void logBefore(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logged before UserController Method " + methodName);

        Logger logger = new Logger();
        logger.setTransactionDate(new Date());
        logger.setOperation(methodName);
        logger.setPrinciple(new Users());
    }
}
