package com.example.postgresdemo.injections;

import org.springframework.stereotype.Service;

@Service
public class HelloImpl extends HelloProvider {

	@Override
	public String getMessage() {
		return "Hello World";
	}
}
