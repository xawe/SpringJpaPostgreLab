package program;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import program.CustomerService;


public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//ApplicationContext appContext = new ClassPathXmlApplicationContext(
		//		new String[] { "Spring-Customer.xml" } );
		
		//CustomerService  cust = (CustomerService) appContext.getBean("customerService");
		CustomerService  cust =  new CustomerService();
		cust.setName("Xawe");
		cust.setUrl("www.google.com");
		
		System.out.println("*************************");
        cust.printName();
        System.out.println("*************************");
        cust.printUrl();
        System.out.println("*************************");
        try {
                cust.printThrowException();
        } catch (Exception e) {

        }
	}

}
