package com.example.postgresdemo.injections;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

import org.springframework.beans.factory.serviceloader.ServiceListFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.SpringFactoriesLoader;

//@Configuration
public class MyConfiguration {
	
	@Bean
	public ServiceListFactoryBean serviceFactory() {
		ServiceListFactoryBean serviceListFactoryBean = new ServiceListFactoryBean();
        serviceListFactoryBean.setServiceType(Foo.class);
        
        ServiceLoader<Foo> loader = ServiceLoader.load(Foo.class);
        loader.iterator();
        
        List<Foo> foos = SpringFactoriesLoader.loadFactories(Foo.class, null);
        for (Foo foo : foos) {
			System.out.println(foo.execute());
		}
        return serviceListFactoryBean;
	}	

}