package com.example.postgresdemo.injections;
import java.util.ServiceLoader;

public abstract class HelloProvider {
	public static HelloProvider getDefault() {
        ServiceLoader<HelloProvider> ldr = ServiceLoader.load(HelloProvider.class);
        for (HelloProvider provider : ldr) {
            //We are only expecting one
            return provider;
        }
        throw new Error ("No HelloProvider registered");
    }
	
	public void execute() {
		ServiceLoader<HelloProvider> ldr = ServiceLoader.load(HelloProvider.class);
        for (HelloProvider provider : ldr) {
            //We are only expecting one
            System.out.println(provider.getMessage());
        }	
	}

    public abstract String getMessage();

    public static void main(String[] ignored) {
        HelloProvider provider = HelloProvider.getDefault();
        System.out.println(provider.getMessage());
    }
}