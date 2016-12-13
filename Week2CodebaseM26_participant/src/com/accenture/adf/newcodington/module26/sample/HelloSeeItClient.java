package com.accenture.adf.newcodington.module26.sample;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class HelloSeeItClient {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		// TODO 1 Create a ClassPathResource object using helloSeeIt.xml
		Resource r = new ClassPathResource("helloSeeIt.xml");
		BeanFactory bf = new XmlBeanFactory(r);
		// TODO 2 Create BeanFactory object and pass ClasspathResource to it.

		// TODO 3 Call getBean method of BeanFactory and pass HelloSeeItImpl id
		// to it.
		// REMEMBER: This id was created in hello.xml
		HelloSeeItImpl h1 = (HelloSeeItImpl) bf.getBean("hello");
		// TODO 4 Call getBean method of BeanFactory 3-4 times, each time
		// storing the reference under a new name
		HelloSeeItImpl h2 = (HelloSeeItImpl) bf.getBean("hello");
		HelloSeeItImpl h3 = (HelloSeeItImpl) bf.getBean("hello");
		HelloSeeItImpl h4 = (HelloSeeItImpl) bf.getBean("hello");

		// TODO 5 Call sayHello method using any of the references created above
		System.out.println(h3.sayHello("Peter"));
		// TODO 6 Print the greeting sent by sayHello method
		System.out.println(h1);
		System.out.println(h2);
		System.out.println(h3);
		System.out.println(h4);

	}

}
