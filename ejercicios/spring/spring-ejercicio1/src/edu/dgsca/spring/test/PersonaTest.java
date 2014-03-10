package edu.dgsca.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import edu.dgsca.spring.IPersona;

public class PersonaTest {

	public static void main(String[] args) {
		ApplicationContext ctx;
		try {
			ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
			IPersona fisica = (IPersona) ctx.getBean("fisica");
			imprimeForma(fisica);
			IPersona moral = (IPersona) ctx.getBean("moral");
			imprimeForma(moral);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	private static void imprimeForma(IPersona persona) throws Exception {
		System.out.printf("Tipo de persona %s, con nombre %s y %s%n", persona.getClass().getSimpleName(), 
				persona.getNombreCompleto(), persona.getRFC());
	}

}
