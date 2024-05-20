package com.ex.quartz;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:quartz-config.xml")
public class XmlQuartConfiguration {
}
