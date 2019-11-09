package cn.zhaosoft.learning.bytebuddy;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.JavaModule;

import java.lang.instrument.Instrumentation;

public class Agent {

    public static void premain(String agentArgs, Instrumentation instrumentation) {

        System.out.println("Agent方法开始执行");

        new AgentBuilder.Default()
                .type(ElementMatchers.any())
                .transform(new AgentBuilder.Transformer() {
                    public DynamicType.Builder<?> transform(DynamicType.Builder<?> builder, TypeDescription typeDescription, ClassLoader classLoader, JavaModule javaModule) {
                        return builder
//                                .method(ElementMatchers.any())
                                .method(ElementMatchers.named("hello"))
                                .intercept(MethodDelegation.to(SimpleInterceptor.class))
                                ;
                    }
                })
                .with(new AgentBuilder.Listener() {
                    public void onDiscovery(String typeName, ClassLoader classLoader, JavaModule module, boolean loaded) {

                    }

                    public void onTransformation(TypeDescription typeDescription, ClassLoader classLoader, JavaModule module, boolean loaded, DynamicType dynamicType) {
                        System.out.println("onTransformation ：" + typeDescription);
                        System.out.println("onTransformation ：" + dynamicType);
                    }

                    public void onIgnored(TypeDescription typeDescription, ClassLoader classLoader, JavaModule module, boolean loaded) {

                    }

                    public void onError(String typeName, ClassLoader classLoader, JavaModule module, boolean loaded, Throwable throwable) {

                    }

                    public void onComplete(String typeName, ClassLoader classLoader, JavaModule module, boolean loaded) {

                    }
                })
                .installOn(instrumentation);

        new AgentBuilder.Default()
                .type(ElementMatchers.any())
                .transform((builder, type, classLoader, module) ->
                        builder.method(ElementMatchers.any())
                                .intercept(MethodDelegation.to(TimingInterceptor.class))
                ).installOn(instrumentation);

        System.out.println("Agent方法执行结束");
    }

}
