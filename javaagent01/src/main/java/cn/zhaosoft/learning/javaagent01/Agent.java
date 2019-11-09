package cn.zhaosoft.learning.javaagent01;

import java.lang.instrument.Instrumentation;

public class Agent {

    public static void premain(String agentArgs, Instrumentation instrumentation)  {

        instrumentation.addTransformer(new ClassFileTransformerDemo());

        System.out.println("一点不萌");
    }

}
