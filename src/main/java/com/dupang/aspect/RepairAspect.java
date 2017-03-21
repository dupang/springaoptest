/*
 * Copyright © 2017 damai.cn All rights reserved. 北京红马传媒文化发展有限公司 版权所有 大麦网 声明: 对未经许可擅自反编译、修改和使用本源码者，本公司保留追究其法律责任的权利.
 */
package com.dupang.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

/**
 * <p>
 * ClassName:com.dupang.aspect.RepairAspect
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
@Aspect
public class RepairAspect {
    // 匹配com.owenapp.service.impl包下所有类的、
    // 所有方法的执行作为切入点
    @AfterThrowing(throwing = "ex", pointcut = "execution(* com.dupang.service.impl.*.*(..))")
    // 声明ex时指定的类型会限制目标方法必须抛出指定类型的异常
    // 此处将ex的类型声明为Throwable，意味着对目标方法抛出的异常不加限制
    public void doRecoveryActions(Throwable ex) {
        System.out.println("目标方法中抛出的异常:" + ex);
        System.out.println("模拟Advice对异常的修复...");
    }
}