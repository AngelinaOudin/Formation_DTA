package fr.form.SpringJv;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;

@Constraint(validatedBy= IdentifiantValidator.class)
@Target(value= ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Identifiant {
	String message() default "{valisator.identifiant}";
	Class<?>[] groups() default {};
	
}
