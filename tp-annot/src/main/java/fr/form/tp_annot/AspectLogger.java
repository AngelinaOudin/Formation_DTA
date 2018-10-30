package fr.form.tp_annot;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectLogger {

	@After("execution(* fr.form.tp_annot.DummyService.getDummies())")
	public void logAfter() {
		System.out.println("Log after is called");
	}
	@Before("execution(* fr.form.tp_annot.DummyService.*(..))")
	public void logBefore(JoinPoint joinPoint) {
		System.out.println("Log BEFORE is called: " + joinPoint.getSignature().getName());
	}
	
	@AfterThrowing(throwing= "ex", pointcut="execution(* fr.form.tp_annot.DummyService.saveDummy(..))")
	public void logException() {
		System.out.println("Exception is thrown");
	}
	
	@Around("execution(* fr.form.tp_annot.DummyService.saveDummy(..))")
	public Object logAround(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("Before calling pjp");
		Object returnedVaue = pjp.proceed();
		System.out.println("After calling pjp");
		long debut = System.currentTimeMillis();
        System.out.println(System.currentTimeMillis() - debut + "ms");
		return returnedVaue;
	}
}
