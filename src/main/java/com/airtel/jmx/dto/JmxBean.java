package com.airtel.jmx.dto;

import org.springframework.jmx.export.annotation.*;
import org.springframework.jmx.export.naming.SelfNaming;

import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;

//@ManagedResource(objectName="bean:name=testBean4", description="My Managed Bean", log=true,
//        logFile="jmx.log", currencyTimeLimit=15, persistPolicy="OnUpdate", persistPeriod=200,
//        persistLocation="foo", persistName="bar")
public class JmxBean implements SelfNaming, IJmxBean {

    private String name;
    private int age;
    private boolean isSuperman;

    //@ManagedAttribute(defaultValue="foo", persistPeriod=300)
    public String getName() {
        return name;
    }

//    @ManagedAttribute(description="The Name Attribute",
//            currencyTimeLimit=20,
//            defaultValue="bar",
//            persistPolicy="OnUpdate")
    public void setName(String name) {
        this.name = name;
    }

//    @ManagedAttribute(description="The Age Attribute", currencyTimeLimit=15)
    public int getAge() {
        return age;
    }


    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSuperman() {
        return isSuperman;
    }

    public void setSuperman(boolean superman) {
        isSuperman = superman;
    }
//
//    @ManagedOperation(description="Add two numbers")
//    @ManagedOperationParameters({
//            @ManagedOperationParameter(name = "x", description = "The first number"),
//            @ManagedOperationParameter(name = "y", description = "The second number")})
    public int add(int x, int y) {
        return x + y;
    }

    public JmxBean(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public ObjectName getObjectName() throws MalformedObjectNameException {
        return new ObjectName("testBean:name=" + getClass().getName());
    }

    public void dontExposeMe() {
        throw new RuntimeException();
    }
}
