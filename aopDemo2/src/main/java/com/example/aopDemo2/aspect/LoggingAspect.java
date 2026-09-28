package com.example.aopDemo2.aspect;

import com.example.aopDemo2.dto.Student;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

//    @Before("execution(String com.example.aopDemo2.service.StudentService.createStudent())")
//    public void logBeforeMethod(JoinPoint joinPoint){
//        System.out.println("Student is going to be saved");
//    }


//    @AfterReturning(
//            value = "execution(" +
//                    "* com.example.aopDemo2.service.StudentService" +
//                    ".createStudent(..))",
//            returning = "result")
//    public void logAfterReturningMethod(Student result){
//        System.out.println("logAfterReturning Method called");
//
//        result.setName("Nidhi");
//        result.setAge(21);
//
//        System.out.println("Intercepted createStudent()");
//    }

    //    @AfterThrowing(
//            value = "execution(" + "* com.example.aopDemo2.service.StudentService" + ".createStudent(..))",
//            throwing = "exception")
//    public void logAfterThrowingMethod(Throwable exception){
//        System.out.println("Exception type:" + exception.getClass().getName());
//        System.out.println("Exception message:" + exception.getMessage());
//    }
//
    @Around(
            value = "execution(" + "* com.example.aopDemo2.service.StudentService" + ".createStudent(..))")
    public Student logAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Starting: " + joinPoint.getSignature().getName());

        try {
            Student result = (Student) joinPoint.proceed();

            System.out.println("After target method");

            return result;
        } catch (Exception e) {
            System.out.println("Exception failed: " + e.getMessage());
            throw e;
        } finally {
            System.out.println("Execution completed");
        }

    }


}
