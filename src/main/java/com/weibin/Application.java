package com.weibin;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        System.out.println("main");
        String[] configLocations = new String[]{"classpath:applicationContext.xml"};
        // 创建Spring IoC容器，并根据配置文件在容器中实例化对象
        ApplicationContext context = new ClassPathXmlApplicationContext(configLocations);
    }
}
