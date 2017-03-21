/*
 * Copyright © 2017 damai.cn All rights reserved. 北京红马传媒文化发展有限公司 版权所有 大麦网 声明: 对未经许可擅自反编译、修改和使用本源码者，本公司保留追究其法律责任的权利.
 */
package com.dupang.service.impl;

import com.dupang.service.World;
import org.springframework.stereotype.Component;

/**
 * <p>
 * ClassName:com.dupang.service.impl.WorldImpl
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
@Component("world")
public class WorldImpl implements World {
    // 定义一个简单方法，模拟应用中的业务逻辑方法
    public void bar() {
        System.out.println("执行World组件的bar()方法");
    }
}
