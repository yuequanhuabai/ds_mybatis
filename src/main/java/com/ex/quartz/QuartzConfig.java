//package com.ex.quartz;
//
//import org.quartz.*;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class QuartzConfig {
//
//    @Bean
//    public JobDetail myJobDetail() {
//        return JobBuilder.newJob(MyJob.class)
//                .withIdentity("myJob", "group1")
//                .storeDurably()
//                .build();
//    }
//
//    @Bean
//    public Trigger myJobTrigger(JobDetail job) {
//        return TriggerBuilder.newTrigger()
//                .forJob(job)
//                .withIdentity("myJobTrigger", "group1")
//                .withSchedule(
//                        SimpleScheduleBuilder.simpleSchedule()
//                                .withIntervalInSeconds(10)
//                                .repeatForever()
//                )
//                .build();
//    }
//}
