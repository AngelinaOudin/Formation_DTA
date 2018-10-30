package fr.form.SpringJv;

import java.time.LocalDate;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import fr.form.dao.JeuDao;
import fr.form.model.JeuVideo;


@ComponentScan("fr.form")
@EnableTransactionManagement
public class Application 
{
    public static void main( String[] args )
    {
       AbstractApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
       
       JeuDao dao = context.getBean(JeuDao.class);
       JeuVideo video = new JeuVideo("Totosdsd", LocalDate.now(), "editeur");
       
       
       List<JeuVideo> jeux = dao.getAll();
       for(JeuVideo j : jeux) {
    	   System.out.println(j.toString());
       }
       context.close();
    }
}
