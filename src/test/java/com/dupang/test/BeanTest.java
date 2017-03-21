/*
 * Copyright © 2017 damai.cn All rights reserved. 北京红马传媒文化发展有限公司 版权所有 大麦网 声明: 对未经许可擅自反编译、修改和使用本源码者，本公司保留追究其法律责任的权利.
 */
package com.dupang.test;

import com.dupang.service.Hello;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p>
 * ClassName:com.dupang.test.BeanTest
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
public class BeanTest {

    public static void main(String[] args) {
        // 创建Spring容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Hello hello = ctx.getBean("hello", Hello.class);
        hello.foo();
        hello.addUser("o", "7788");
        // World world = ctx.getBean("world", World.class);
        // world.bar();

    }
}
