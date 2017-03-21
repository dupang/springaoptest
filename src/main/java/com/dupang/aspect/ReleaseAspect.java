/*
 * Copyright © 2017 damai.cn All rights reserved. 北京红马传媒文化发展有限公司 版权所有 大麦网 声明: 对未经许可擅自反编译、修改和使用本源码者，本公司保留追究其法律责任的权利.
 */
package com.dupang.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

/**
 * <p>
 * ClassName:com.dupang.aspect.ReleaseAspect
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
public class ReleaseAspect {
    // 匹配com.owenapp.service包下所有类的、
    // 所有方法的执行作为切入点
    @After("execution(* com.dupang.service.*.*(..))")
    public void release() {
        System.out.println("模拟方法结束后的释放资源...");
    }
}