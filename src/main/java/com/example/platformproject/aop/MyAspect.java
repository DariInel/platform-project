package com.example.platformproject.aop;

import com.example.platformproject.util.CustomResponse;
import com.example.platformproject.util.CustomStatus;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
@Aspect
@Log4j2
public class MyAspect {

    @Around("Pointcuts.updateMethods()")
    public Object aroundUpdatingAdvice(ProceedingJoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        Object result;
        try{
            result = joinPoint.proceed();
        } catch (NoSuchElementException e){
            log.error(e.getMessage(), e);
            result = new CustomResponse<>(null, CustomStatus.NOT_FOUND);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
            result = new CustomResponse<>(null, CustomStatus.EXCEPTION);
        }
        return result;
    }

    @Around("Pointcuts.addMethodStudent()")
    public Object aroundAddStudentAdvice(ProceedingJoinPoint joinPoint){

        Object result;
        try{
            result = joinPoint.proceed();
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
            result = new CustomResponse<>(null, CustomStatus.EXCEPTION);
        }
        return result;
    }

    @Around("Pointcuts.addMethodChange()")
    public Object aroundAddChangeAdvice(ProceedingJoinPoint joinPoint){

        Object result;
        try{
            result = joinPoint.proceed();
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
            result = new CustomResponse<>(null, CustomStatus.EXCEPTION);
        }
        return result;
    }
}
