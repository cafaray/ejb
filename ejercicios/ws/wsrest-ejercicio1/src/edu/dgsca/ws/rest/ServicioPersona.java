package edu.dgsca.ws.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MultivaluedMap;

import edu.dgsca.modelo.Persona;


@Path("/servicioPersonas/")
@Produces("application/json") //especificamos que el tipo de medio de salida sera un objeto jason
public class ServicioPersona {

	private static List<Persona> personas = new ArrayList<Persona>();
	
	public ServicioPersona() {
		super();
		Persona yomero = new Persona("Alberto","Lopez Plancarte", "MIRF999999XXX");
		Persona tumero = new Persona("Luis","Sanchez Robledo", "TURF999999XXX");
		Persona elmero = new Persona("Raul","Gonzalez Gonzalez", "SURF999999XXX");
		personas.add(yomero);
		personas.add(tumero);
		personas.add(elmero);
	}
	
	@GET
	@Path("/personas")
	public List<Persona> getPersonas() { 
		return personas;
	}
	
	@POST
	@Path("/personas")
	public void addPersona(MultivaluedMap<String, String> parametros) {
		Persona p = new Persona();
		p.setNombre(parametros.getFirst("nombre"));
		p.setApellidos(parametros.getFirst("apellidos"));
		p.setRfc(parametros.getFirst("rfc"));
		personas.add(p);
	}	
}
