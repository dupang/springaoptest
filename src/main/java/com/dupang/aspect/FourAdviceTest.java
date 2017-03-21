/*
 * Copyright © 2017 damai.cn All rights reserved. 北京红马传媒文化发展有限公司 版权所有 大麦网 声明: 对未经许可擅自反编译、修改和使用本源码者，本公司保留追究其法律责任的权利.
 */
package com.dupang.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Arrays;

/**
 * <p>
 * ClassName:com.dupang.aspect.FourAdviceTest
 * </p>
 * <p>
 * 描述:
 * </p>
 * <p>
 * 日期:2017年03月21
 * </p>
 *
 * @author duguanxin
 * @version 1.0
 * @since 1.0
 */
// 定义一个切面
@Aspect
public class FourAdviceTest {
    // 定义Around增强处理
    @Around("execution(* com.dupang.service.impl.*.*(..))")
    public Object processTx(ProceedingJoinPoint jp) throws java.lang.Throwable {
        System.out.println("Around增强：执行目标方法之前，模拟开始事务...");
        // 访问执行目标方法的参数
        Object[] args = jp.getArgs();
        // 当执行目标方法的参数存在，
        // 且第一个参数是字符串参数
        if (args != null && args.length > 0 && args[0].getClass() == String.class) {
            // 修改目标方法调用参数的第一个参数
            args[0] = "【增加的前缀】" + args[0];
        }
        // 执行目标方法，并保存目标方法执行后的返回值
        Object rvt = jp.proceed(args);
        System.out.println("Around增强：执行目标方法之后，模拟结束事务...");
        // 如果rvt的类型是Integer，将rvt改为它的平方
        if (rvt != null && rvt instanceof Integer)
            rvt = (Integer) rvt * (Integer) rvt;
        return rvt;
    }

    // 定义Before增强处理
    @Before("execution(* com.dupang.service.impl.*.*(..))")
    public void authority(JoinPoint jp) {
        System.out.println("Before增强：模拟执行权限检查");
        // 返回被织入增强处理的目标方法
        System.out.println("Before增强：被织入增强处理的目标方法为：" + jp.getSignature().getName());
        // 访问执行目标方法的参数
        System.out.println("Before增强：目标方法的参数为：" + Arrays.toString(jp.getArgs()));
        // 访问被增强处理的目标对象
        System.out.println("Before增强：被织入增强处理的目标对象为：" + jp.getTarget());
    }

    // 定义AfterReturning增强处理
    @AfterReturning(pointcut = "execution(* com.dupang.service.impl.*.*(..))", returning = "rvt")
    public void log(JoinPoint jp, Object rvt) {
        System.out.println("AfterReturning增强：获取目标方法返回值:" + rvt);
        System.out.println("AfterReturning增强：模拟记录日志功能...");
        // 返回被织入增强处理的目标方法
        System.out.println("AfterReturning增强：被织入增强处理的目标方法为：" + jp.getSignature().getName());
        // 访问执行目标方法的参数
        System.out.println("AfterReturning增强：目标方法的参数为：" + Arrays.toString(jp.getArgs()));
        // 访问被增强处理的目标对象
        System.out.println("AfterReturning增强：被织入增强处理的目标对象为：" + jp.getTarget());
    }

    // 定义After增强处理
    @After("execution(* com.dupang.service.impl.*.*(..))")
    public void release(JoinPoint jp) {
        System.out.println("After增强：模拟方法结束后的释放资源...");
        // 返回被织入增强处理的目标方法
        System.out.println("After增强：被织入增强处理的目标方法为：" + jp.getSignature().getName());
        // 访问执行目标方法的参数
        System.out.println("After增强：目标方法的参数为：" + Arrays.toString(jp.getArgs()));
        // 访问被增强处理的目标对象
        System.out.println("After增强：被织入增强处理的目标对象为：" + jp.getTarget());
    }
}
