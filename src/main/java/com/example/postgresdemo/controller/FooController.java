package com.example.postgresdemo.controller;

import java.util.List;
import java.util.ServiceLoader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.serviceloader.ServiceListFactoryBean;
import org.springframework.core.io.support.SpringFactoriesLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.postgresdemo.injections.Foo;
import com.example.postgresdemo.injections.Foone;
import com.example.postgresdemo.injections.HelloImpl;
import com.example.postgresdemo.injections.HelloProvider;


@RestController
public class FooController {

	//@Autowired
	//private List<Foo> myFoo;
	
	@Autowired
	private HelloProvider hp;
	
	@GetMapping("/foo")
	public String getPing() {
		
		hp.execute();
		//hp.getDefault().g;
		
		ServiceListFactoryBean serviceListFactoryBean = new ServiceListFactoryBean();
        serviceListFactoryBean.setServiceType(Foo.class);
        
        ServiceLoader<Foo> loader = ServiceLoader.load(Foo.class);
        loader.iterator();
        
        List<Foo> foos = SpringFactoriesLoader.loadFactories(Foo.class, null);
        
        for (Foo foo : foos) {
			System.out.println(foo.execute());
		}
		
        //return serviceListFactoryBean;

    	//System.out.println(service.createQuestion("Its my question"));
        //return questionRepository.findAll(pageable);
    	return "Pong!";
    }
}
