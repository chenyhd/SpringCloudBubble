package com.chenyh.aop;


import com.chenyh.exception.IntranetException;
import com.chenyh.util.IPUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
public class IntranetAop {

    public IntranetAop() {
        System.out.println("aop-----》实例化");
    }

    @Pointcut("@annotation(com.chenyh.annotation.Intranet)")
    public void intranetAop() {
        System.out.println("这是一个切点");

    }

    @Before(value = "intranetAop()")
    public void  beafore(JoinPoint point) throws IntranetException {
        // 得到request对象
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();


        String ipAddress = attributes.getRequest().getRemoteAddr();

        System.out.println("attributes.getRequest().getRemoteAddr()=====>"
                +ipAddress);

        if (!IPUtil.internalIp(ipAddress)) {
            throw new IntranetException("您没有权限访问");
        }

        System.out.println("before");

    }
}
