package edu.dgsca.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edu.dgsca.modelo.Persona;

public class TestJpa {
	
	 private static final String PERSISTENCE_UNIT_NAME = "jpa-ejercicio1";
     private static EntityManagerFactory factory;
	
	public TestJpa() {
		System.out.println("Se genero la clase para prueba de persistencia");
	}

	private static Persona generaPersona(String nombre, String apellidos, String rfc){
		Persona persona = new Persona();
		persona.setNombre(nombre);
		persona.setApellidos(apellidos);
		persona.setRfc(rfc);
		return persona;
	}
	
	public static void main(String[] args) {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Persona persona = TestJpa.generaPersona("Omar", "Duarte López", "DULO810912LM5");
		em.persist(persona);
		em.getTransaction().commit();
		em.close();
	}

}
