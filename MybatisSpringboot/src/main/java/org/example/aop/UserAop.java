package org.example.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Deacription TODO
 * @Author majian
 * @Date 2020/12/9
 * @Version 1.0
 **/

@Aspect
@Component
public class UserAop {

    private static Logger logger = LoggerFactory.getLogger(UserAop.class);
    /**
     * 定义切入点，切入点为com.example.demo.aop.AopController中的所有函数
     *通过@Pointcut注解声明频繁使用的切点表达式
     */
    @Pointcut("execution(public * org.example.controller.UserController.*(..)))")
    public void UserAspect(){
    }

    /**
     * @description  在连接点执行之前执行的通知
     */
    @Before("UserAspect()")
    public void doBeforeRequest() {
        logger.info("执行doBeforeReques");
    }

    /**
     * @description  在连接点执行之后执行的通知（返回通知和异常通知的异常）
     */
    @After("UserAspect()")
    public void doAfterRequest() {
        logger.info("执行doAfterRequest");
    }

    @Around("UserAspect()")
    public Object arround(ProceedingJoinPoint pjp) {
        logger.info("方法环绕start.....");
        try {
            logger.info("requestParams:" + Arrays.toString(pjp.getArgs()));
            Object o =  pjp.proceed();
            logger.info("responseParams:" + o);
            return o;
        } catch (Throwable e) {
            e.printStackTrace();
            return e;
        }

    }

//    /**
//     * @description  在连接点执行之后执行的通知（返回通知）
//     */
//    @AfterReturning("UserAspect()")
//    public void doAfterReturningRequest(){
//        System.out.println("返回通知：AfterReturningRequest");
//    }
//
//    /**
//     * @description  在连接点执行之后执行的通知（异常通知）
//     */
//    @AfterThrowing("UserAspect()")
//    public void doAfterThrowingRequest(){
//        System.out.println("异常通知：doAfterThrowingRequest！");
//    }
}
