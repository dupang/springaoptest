/*
 * Copyright © 2017 damai.cn All rights reserved. 北京红马传媒文化发展有限公司 版权所有 大麦网 声明: 对未经许可擅自反编译、修改和使用本源码者，本公司保留追究其法律责任的权利.
 */
package com.dupang.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * <p>
 * ClassName:com.dupang.aspect.TxAspect
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
public class TxAspect {
    // 匹配com.owen.app.service.impl包下所有类的、
    // 所有方法的执行作为切入点
    @Around("execution(* com.dupang.service.impl.*.*(..))")
    public Object processTx(ProceedingJoinPoint jp) throws java.lang.Throwable {
        System.out.println("执行目标方法之前，模拟开始事务...");
        // 获取目标方法原始的调用参数
        Object[] args = jp.getArgs();
        if (args != null && args.length > 1) {
            // 修改目标方法的第一个参数
            args[0] = "【增加的前缀】" + args[0];
        }
        // 以改变后的参数去执行目标方法，并保存目标方法执行后的返回值
        Object rvt = jp.proceed(args);
        System.out.println("执行目标方法之后，模拟结束事务...");
        // 如果rvt的类型是Integer，将rvt改为它的平方
        if (rvt != null && rvt instanceof Integer)
            rvt = (Integer) rvt * (Integer) rvt;
        return rvt;
    }
}