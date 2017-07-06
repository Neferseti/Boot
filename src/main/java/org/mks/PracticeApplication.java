package org.mks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
@EntityScan(basePackages = { "org.mks.one.entities", "org.mks.two.entities" })
@ComponentScan
public class PracticeApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(PracticeApplication.class, args);

//		String[] beanName = context.getBeanDefinitionNames();
//
//		for (String bean : beanName) {
//			System.out.println(bean);
//		}
//		System.out.println();
	}
}
