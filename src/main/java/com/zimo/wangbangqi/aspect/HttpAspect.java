package com.zimo.wangbangqi.aspect;

import com.zimo.wangbangqi.dto.WaiterDto;
import com.zimo.wangbangqi.enums.ResultEnum;
import com.zimo.wangbangqi.exception.JudgeException;
import com.zimo.wangbangqi.service.collectionService.AdminWaiterService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.CodeSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * AOP切面
 */
//引入切面
@Aspect
//引入到Spring容器中
@Component
public class HttpAspect {

//import org.slf4j.Logger;  为spring自带的。
    private static final Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Autowired
    AdminWaiterService adminWaiterService;
//    加 ..  表示任何在里面的参数都会被拦截,GirlController中的所有方法都会被拦截
//    切点
    @Pointcut("execution(public * com.zimo.wangbangqi.controller.GirlController.*(..))")
    public void log(){}
    //管理员权限，所有Controller中已Admin开头的Controller的类中的所有方法。
    @Pointcut("execution(public * com.zimo.wangbangqi.controller.Admin*.*(..))")
    public void right(){}

    //验证管理员是否有权限操作服务人员
    @Pointcut("execution(public * com.zimo.wangbangqi.controller.AdminWaiterController.*(..))")
    public void judge(){}

    @Before("log()")
    public void logBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //url
        logger.info("url={}",request.getRequestURL());
        //method,请求方法
        logger.info("method={}",request.getMethod());
        //ip
        logger.info("ip={}",request.getRemoteAddr());
        //类方法,获取类名+类中的方法
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //参数
        logger.info("args={}",joinPoint.getArgs());
        System.out.println("before.......");
    }

    //后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
    @After("log()")
    public void logAfter(){
//        logger.info("after.........");
        System.out.println("after.........");
    }

    /**
     * 处理完请求后
     */
    @AfterReturning(pointcut = "log()",returning = "object")
    public void doAfterReturning(Object object){
        logger.info("response={}",object.toString());
        System.out.println("AfterReturning............");
    }
    @AfterThrowing(pointcut = "log()")
    public void throwss(JoinPoint joinPoint){
//        logger.info("方法异常时执行：{}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        System.out.println("AfterThrowing...........");
    }

//    //环绕通知,环绕增强，相当于MethodInterceptor
//    @Around("log()")
//    public Object arround(ProceedingJoinPoint pjp) {
//        System.out.println("方法环绕start.....");
//        try {
//            Object o =  pjp.proceed();
//            System.out.println("方法环绕proceed，结果是 :" + o);
//            return o;
//        } catch (Throwable e) {
//            e.printStackTrace();
//            return null;
//        }
//    }

    @Before("judge()")
    public void judgeBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //url
        logger.info("url={}",request.getRequestURL());
        //method,请求方法
        logger.info("method={}",request.getMethod());
        //ip
        logger.info("ip={}",request.getRemoteAddr());
        //类方法,获取类名+类中的方法
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //参数
        logger.info("args={}",joinPoint.getArgs());
        System.out.println("before.......");

        Object [] args = joinPoint.getArgs();
        String [] argsName = ((CodeSignature)joinPoint.getStaticPart().getSignature()).getParameterNames();
//        for (Object o : args){
//            System.out.println(o);
//        }
//        for (String name : argsName){
//            System.out.println(name);
////        }
//        Integer adminId = null;
//        Integer waiterId = null;
//        WaiterDto waiterDto = null;
//        for(int i = 0 ; i < args.length; i++){
//            if("adminId".equals(argsName[i]))
//                adminId = (Integer) args[i];
//            if("waiterId".equals(argsName[i]))
//                waiterId = (Integer ) args[i];
//            if("waiterDto".equals(argsName[i]))
//                waiterDto =(WaiterDto) args[i];
//        }
//        if(waiterDto!=null && waiterId ==null){
//            waiterId = waiterDto.getId();
//        }
//        //TODO:验证权限
//        List<Integer> list = adminWaiterService.getWaiterIdsByAdminId((Integer) args[0]);
//        if(!list.contains(waiterId)){
//            throw new JudgeException(ResultEnum.NO_RIGHTS);
//        }
    }

}
