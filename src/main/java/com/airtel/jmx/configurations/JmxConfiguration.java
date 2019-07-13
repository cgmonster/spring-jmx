package com.airtel.jmx.configurations;


import com.airtel.jmx.dto.IJmxBean;
import com.airtel.jmx.dto.JmxBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.export.MBeanExporter;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class JmxConfiguration {

    @Autowired
    ApplicationContext ctx;

    @Bean
    public MBeanExporter exporter() {
        MBeanExporter m = new MBeanExporter();
        Map<String, Object> map = new HashMap<String, Object>();
        JmxBean testBean = (JmxBean) ctx.getBean("testBean");
        map.put("testBean", testBean);
        m.setBeans(map);
        return m;
    }

    @Bean
    public JmxBean testBean() {
        return new JmxBean("test", 100);
    }

    @Bean
    public IJmxBean testBean1() {
        IJmxBean iJmxBean = new JmxBean("test2", 100);
        return iJmxBean;
    }

//    @Bean
//    public MBeanServerFactoryBean mBeanServer(){
//        return new MBeanServerFactoryBean();
//    }
//    @Lazy
//    @Bean
//    public MBeanExporter exporter(){
//        MBeanExporter m = new MBeanExporter();
//        Map<String,Object> map = new HashMap<String, Object>();
//        map.put("testBean1",testBean());
//        m.setBeans(map);
//        m.setServer((MBeanServer) mbeanServer());
//        return m;
//    }

}
