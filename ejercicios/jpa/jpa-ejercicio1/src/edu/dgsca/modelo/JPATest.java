package edu.dgsca.modelo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class JPATest {
	private static final String PERSISTENCE_UNIT_NAME = "jpa-ejercicio1";
    private static EntityManagerFactory factory;
    
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
		Persona persona = JPATest.generaPersona("Jacinto", "Verdaguer", "VERJ870221KU8");
		em.persist(persona);
		em.getTransaction().commit();
		em.close();
	}
}
