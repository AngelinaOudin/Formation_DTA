package fr.form.tp_annot;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * Hello world!
 *
 */

public class Main {
	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(App.class);
		DummyService service = context.getBean(DummyService.class);
		service.getDummies();
		try {
			service.deleteDummmy(100L);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			service.deleteDummmy(null);
		} catch (Exception e1) {
			System.out.println("Exception thrown in main...");
		}
		try {
			service.saveDummy(new Dummy());;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
