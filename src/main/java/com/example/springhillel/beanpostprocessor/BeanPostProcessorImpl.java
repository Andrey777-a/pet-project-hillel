package com.example.springhillel.beanpostprocessor;

import org.springframework.beans.factory.config.BeanPostProcessor;

public class BeanPostProcessorImpl implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String name){
        System.out.println(bean.getClass() + " - Called postProcessBeforeInitialization() for " + name);
        return bean;
    }

   /* @Override
    public Object postProcessAfterInitialization(Object bean, String name){
        System.out.println(bean.getClass() + "Called after postProcessBeforeInitialization() for " + name);
        return bean;
    }*/
    
    
}
