package org.thewhitemage13;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LifeCycleHooksDemoApplication {

    public static void main(String[] args) {
        System.out.println("---> Program started");

        ApplicationContext context = new AnnotationConfigApplicationContext(LifeCycleHooksDemoConfiguration.class);

        System.out.println("---> Context created");

        printBeanDefinition(context);

        demoBeanCreatedOnlyOnce(context);

        closeContext(context);
    }

    private static void closeContext(ApplicationContext context) {
        System.out.println("---> Context closed");

        ((AnnotationConfigApplicationContext) context).close();

        System.out.println("---> Context closed");
    }

    private static void demoBeanCreatedOnlyOnce(ApplicationContext context) {
        System.out.println("---> Context created only once");

        LifeCycleDemo myFirstBean = context.getBean("lifeCycle" ,LifeCycleDemo.class);

        LifeCycleHooksDemoConfiguration configuration = context.getBean(LifeCycleHooksDemoConfiguration.class);

        LifeCycleDemo mySecondBean = configuration.lifeCycleDemo();

        System.out.println(myFirstBean.equals(mySecondBean));

        System.out.println("---> Context created only once");
    }

    private static void printBeanDefinition(ApplicationContext context) {
        System.out.println("---> Context definition");

        for (String s : context.getBeanDefinitionNames()) {
            System.out.println(s + ">>" + context.getBean(s));
        }

        System.out.println("---> Context definition");
    }
}
