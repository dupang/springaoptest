/*
 * Copyright © 2017 damai.cn All rights reserved. 北京红马传媒文化发展有限公司 版权所有 大麦网 声明: 对未经许可擅自反编译、修改和使用本源码者，本公司保留追究其法律责任的权利.
 */
package com.dupang.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

/**
 * <p>
 * ClassName:com.dupang.aspect.LogAspect
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
public class LogAspect {
    // 匹配com.owenapp.service.impl包下所有类的、
    // 所有方法的执行作为切入点
    @AfterReturning(returning = "rvt", pointcut = "execution(* com.dupang.service.impl.*.*(..))")
    // 声明rvt时指定的类型会限制目标方法必须返回指定类型的值或没有返回值
    // 此处将rvt的类型声明为Object，意味着对目标方法的返回值不加限制
    public void log(Object rvt) {
        System.out.println("获取目标方法返回值:" + rvt);
        System.out.println("模拟记录日志功能...");
    }
}
