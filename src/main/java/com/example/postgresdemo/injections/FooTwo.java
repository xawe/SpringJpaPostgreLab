package com.example.postgresdemo.injections;

import org.springframework.stereotype.Service;

@Service
public class FooTwo implements Foo{

	@Override
	public String execute() {
		// TODO Auto-generated method stub
		return "Hellow Foo 2";
	}

}
