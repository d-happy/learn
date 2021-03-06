package com.kh.student;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		
		String location1 = "classpath:app-ctx1.xml";
		String location2 = "classpath:app-ctx2.xml";
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(location1, location2);
		
		Student s = ctx.getBean("hong", Student.class);
		Person p = ctx.getBean("kim", Person.class);
		
		System.out.println(s);
		System.out.println(p);
		
		ctx.close();
	}
}
