package com.ex.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class MyBean implements InitializingBean, DisposableBean {

    private static final Logger logger = LoggerFactory.getLogger(MyBean.class);

    private String id;

    private String name;

    private MyBean2 myBean2;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyBean2 getMyBean2() {
        return myBean2;
    }

    public void setMyBean2(MyBean2 myBean2) {
        this.myBean2 = myBean2;
    }


    public void init() {
       logger.info("自定义的init方法");
    }

    public void cleanup() {
        logger.info("自定义的 destory-method 方法");

    }


    public MyBean() {
        logger.info("myBean 的构造函数！");
    }

    @PostConstruct
    public void postConstruct() {
        logger.info("@PostConstruct方法调用");
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("afterPropertiesSet方法调用");

    }

    @Override
    public void destroy() throws Exception {
        logger.info("DisposableBean.destroy方法调用");

    }

    @PreDestroy
    public void preDestory(){
        logger.info("@PreDestroy 方法调用");
    }





}
