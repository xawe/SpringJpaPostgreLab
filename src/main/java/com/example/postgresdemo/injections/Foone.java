package com.example.postgresdemo.injections;

import org.springframework.stereotype.Service;

@Service
public class Foone implements Foo{

	@Override
	public String execute() {
		// TODO Auto-generated method stub
		return "This is fooOne";
	}

}
