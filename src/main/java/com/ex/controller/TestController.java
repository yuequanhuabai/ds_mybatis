package com.ex.controller;


import org.springframework.web.bind.annotation.RestController;

@RestController(("/test1"))
public class TestController {

//    @GetMapping("/t1")
//    public void setCorePool() {
//
//        ThreadPoolManager s = new ThreadPoolManager(executor);
//        s.setCorePoolSize(2);
//
//    }
//
//
//    @GetMapping("/t2")
//    public int getCorePool() {
//
//        ThreadPoolManager s = new ThreadPoolManager(executor);
//
//        int corePoolSize = s.getCorePoolSize();
//        return corePoolSize;
//
//    }

//    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException, IOException {
////        MBeanServer platformMBeanServer = ManagementFactory.getPlatformMBeanServer();
////
////        ThreadPoolManager threadPoolManager = new ThreadPoolManager();
////
////        ObjectName objectName = new ObjectName("com.example:type=ThreadPoolManager");
////        platformMBeanServer.registerMBean(threadPoolManager,objectName);
//
//
//        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
//
//        // 创建 ThreadPoolExecutor
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(
//                10, 50, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
//
//        // 创建 ThreadPoolManager 实例
//        ThreadPoolManager tpManager = new ThreadPoolManager(executor);
//
//        // 注册 MBean
//        ObjectName name = new ObjectName("com.example:type=ThreadPoolManager");
//        mbs.registerMBean(tpManager, name);
//
//        System.out.println("MBean registered. Press Enter to exit.");
//        System.in.read();
//
//    }


}
