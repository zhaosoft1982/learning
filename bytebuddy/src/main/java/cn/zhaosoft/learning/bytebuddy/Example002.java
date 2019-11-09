package cn.zhaosoft.learning.bytebuddy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;

public class Example002 {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException {
        Class dynamicType = new ByteBuddy()
                .subclass(Dog.class)
                .method(ElementMatchers.named("hello"))
                .intercept(MethodDelegation.to(SimpleInterceptor.class))
                .make()
                .load(Example002.class.getClassLoader(), ClassLoadingStrategy.Default.WRAPPER)
                .getLoaded();

        Object s = dynamicType.newInstance();
        System.out.println(((Dog)s).hello());
    }

}
