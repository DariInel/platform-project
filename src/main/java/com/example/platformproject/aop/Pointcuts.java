package com.example.platformproject.aop;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {
    @Pointcut("execution(* com.example.platformproject.service.StudentService.addStudent())")
    public void addMethodStudent(){

    }

    @Pointcut("execution(* com.example.platformproject.service.StudentService.update*(..))")
    public void updateMethods(){

    }

    @Pointcut("execution(* com.example.platformproject.service.NotificationService.addChange())")
    public void addMethodChange(){

    }
}
