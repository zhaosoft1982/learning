package cn.zhaosoft.learning.bytebuddy;

import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.SuperCall;

import java.util.concurrent.Callable;

public class SimpleInterceptor {

    @RuntimeType
    public static Object intercept(@SuperCall Callable<?> zuper) throws Exception {
        System.out.println("intercept：方法被拦截了");
        return Integer.parseInt(zuper.call().toString())+5;
//        return 5;
    }

}