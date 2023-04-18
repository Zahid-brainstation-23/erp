package com.brainstation23.erp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Aspect
@Component
public class BeforeOrganizationRestControllerMethods {

    @Before("execution(* com.brainstation23.erp.controller.rest.OrganizationRestController.*(..))")
    public void verifyAuthoriztionFromJwtToken(JoinPoint joinPoint)
    {
        Object[] args = joinPoint.getArgs();
        MethodSignature methodSig = (MethodSignature) joinPoint.getSignature();
        String[] parametersName = methodSig.getParameterNames();
        int idx = Arrays.asList(parametersName).indexOf("authHeader");
        if(!(args.length > idx) || idx<0){
            return;
        }
        String authHeader = args[idx].toString();
        String token = authHeader.substring(7);

    }
}
