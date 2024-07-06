package org.thewhitemage13;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LifeCycleHooksDemoConfiguration {

    @Bean(name = "lifeCycle",initMethod = "onInited", destroyMethod = "onDestroy")
    public LifeCycleDemo lifeCycleDemo() {
        return new LifeCycleDemo();
    }
}
