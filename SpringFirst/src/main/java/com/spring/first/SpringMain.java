package com.spring.first;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext
				("classpath:META-INF/spring.xml");
		//기본생성자로 문자열을 받아 주소값을 넣어주면 된다.
		//src/mainresource(?)
		MiTv tv = ctx.getBean("mitv", MiTv.class);
		//이게 객체화가 됐을 거임! 이걸 spring.xml의 bean id로 쓰일 거임ㅎ
		System.out.println("tv1:" + tv);
		//싱글톤이 넘어 옴
	}

}
