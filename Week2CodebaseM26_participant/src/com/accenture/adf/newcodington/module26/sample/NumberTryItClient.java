package com.accenture.adf.newcodington.module26.sample;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class NumberTryItClient {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		// TODO 1 Create a ClassPathResource object using numberTryIt.xml 	
		Resource r = new ClassPathResource("numberTryIt.xml");
		
		// TODO 2 Create BeanFactory object and pass ClasspathResource to it.
		BeanFactory bf = new XmlBeanFactory(r);
		
		// TODO 3 Call getBean method of BeanFactory and pass NumberTryItImpl id to it. 
		//        REMEMBER: This id was created in number.xml 
		NumberTryItImpl n1 = (NumberTryItImpl) bf.getBean("numTry");
		
		// TODO 4 Call getBean method of BeanFactory 3-4 times, each time storing the reference under a new name
		NumberTryItImpl n2 = (NumberTryItImpl) bf.getBean("numTry");
		NumberTryItImpl n3 = (NumberTryItImpl) bf.getBean("numTry");
		NumberTryItImpl n4 = (NumberTryItImpl) bf.getBean("numTry");
		// TODO 5 Call add method using any of the references created above
		int sum = n1.add(2, 2);
		
		
		// TODO 6 Print the result sent by add method
		System.out.println("The Sum is: " + sum);
		
		 sum = n2.add(4, 4);
		System.out.println("The Sum is: " + sum);
		sum = n3.add(6, 6);
		System.out.println("The Sum is: " + sum);
		sum = n4.add(8, 8);
		System.out.println("The Sum is: " + sum);
		
	
		System.out.println(n1);
		System.out.println(n2);
		System.out.println(n3);
		System.out.println(n4);
	
		HelloSeeItImpl h1 = (HelloSeeItImpl) bf.getBean("hello");
		
		System.out.println(h1.sayHello("Peter"));
	}

}
