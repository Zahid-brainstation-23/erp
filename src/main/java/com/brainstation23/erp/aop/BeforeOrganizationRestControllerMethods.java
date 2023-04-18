package com.brainstation23.erp.aop;

import com.brainstation23.erp.exception.custom.custom.UnauthorizedAccessException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Aspect
@Component
public class BeforeOrganizationRestControllerMethods {
    private final String SECRET_KEY = "secretkey";

    @Before("execution(* com.brainstation23.erp.controller.rest.OrganizationRestController.*(..))")
    public void verifyAuthoriztionFromJwtToken(JoinPoint joinPoint) throws Exception {
        Object[] args = joinPoint.getArgs();
        MethodSignature methodSig = (MethodSignature) joinPoint.getSignature();
        String[] parametersName = methodSig.getParameterNames();
        int idx = Arrays.asList(parametersName).indexOf("authHeader");
        if(!(args.length > idx) || idx<0){
            return;
        }
        String authHeader = args[idx].toString();

        String token = authHeader;

        Claims claims =null;

            claims = Jwts.parser().setSigningKey(SECRET_KEY.getBytes()).parseClaimsJws(token).getBody();

        String role = (String) claims.get("role");
        if(!role.equalsIgnoreCase("ADMIN")){
            throw new UnauthorizedAccessException("Only admins can access this endpoint");
        }
    }
}
