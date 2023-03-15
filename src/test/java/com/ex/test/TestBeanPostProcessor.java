package com.ex.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class TestBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // 生成了一个新的user对象

        if (beanName.equals("user")) {
            System.out.println(bean);
            User user = new User();
            return user;
        }

        return bean;
    }
}
