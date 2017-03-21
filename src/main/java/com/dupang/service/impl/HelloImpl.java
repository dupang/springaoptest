/*
 * Copyright © 2017 damai.cn All rights reserved. 北京红马传媒文化发展有限公司 版权所有 大麦网 声明: 对未经许可擅自反编译、修改和使用本源码者，本公司保留追究其法律责任的权利.
 */
package com.dupang.service.impl;

import org.springframework.stereotype.Component;

import com.dupang.service.Hello;

/**
 * <p>
 * ClassName:com.dupang.service.impl.HelloImpl
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
@Component("hello")
public class HelloImpl implements Hello {
    // 定义一个简单方法，模拟应用中的业务逻辑方法
    public void foo() {
        System.out.println("执行Hello组件的foo()方法");
    }

    // 定义一个addUser()方法，模拟应用中的添加用户的方法
    public int addUser(String name, String pass) {
        System.out.println("执行Hello组件的addUser添加用户：" + name);
        return 20;
    }
}
