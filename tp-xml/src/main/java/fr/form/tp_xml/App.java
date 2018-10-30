package fr.form.tp_xml;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println("Context loaded !");
		MyObject objA = (MyObject) context.getBean("ObjectA");
		MyObject objB = (MyObject) context.getBean("ObjectB");
		System.out.println("Objet : "+ objA.getName()+" "+objA.getKeywords());
		System.out.println("Objet : "+ objB.getParent().getId());
	}
}
