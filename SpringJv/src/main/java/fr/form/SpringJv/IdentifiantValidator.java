package fr.form.SpringJv;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

public class IdentifiantValidator implements ConstraintValidator<Identifiant, String> {

	public void intialize(Identifiant constraintAnnotation) {
		
	}
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		return value.length() > 5;
	}

}
