package fr.form.tpjdbc;

import java.sql.SQLException;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * Hello world!
 *
 */

@Configuration
@ComponentScan
public class App {
	public static void main(String[] args) throws SQLException {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(App.class);
		ConnexionBone bone = context.getBean(ConnexionBone.class);
		MyJdbcDao jdbc = context.getBean(MyJdbcDao.class);
		jdbc.list();
		context.getBean(MyJdbcDao.class).update();
		System.out.println("UPDATE");
		context.getBean(MyJdbcDao.class).list();

		context.getBean(MyJdbcDao.class).list();
		
		System.out.println("RowCallBack");
		
		
		List<Book>livres = context.getBean(MyJdbcDao.class).getLivres();
		for(Book b : livres) {
			System.out.println(b.getTitle());
		}
		System.out.println("---------------------------------------");
		List<String>auteurs = context.getBean(MyJdbcDao.class).getAuthors();
		for(String s : auteurs) {
			System.out.println(s);
		}
		
		/*System.out.println("---------------------------------------");
		System.out.println(jdbc.getAuthors("Pierre Bordage").toString());
		
		System.out.println("---------------------------------------");
		jdbc.getUserInfoByAlll();
		System.out.println("---------------------------------------");
		//jdbc.mapCsv();*/

		System.out.println("---------------------------------------");
		jdbc.addRows();
		jdbc.list();
	}
}
