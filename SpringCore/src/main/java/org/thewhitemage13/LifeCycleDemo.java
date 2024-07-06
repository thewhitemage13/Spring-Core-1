package org.thewhitemage13;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class LifeCycleDemo {

    public void onInited() {
        System.out.println("Life cycle: onInited");
    }

    public void onDestroy() {
        System.out.println("Life cycle: onDestroy");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Life cycle: @postConstruct");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("Life cycle: @preDestroy");
    }

}
