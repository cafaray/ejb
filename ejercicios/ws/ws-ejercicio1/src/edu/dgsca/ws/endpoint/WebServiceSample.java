package edu.dgsca.ws.endpoint;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(serviceName="webServiceSample", portName="webServiceSamplePort", targetNamespace="http://edu.dgsca.ws")
public class WebServiceSample {

	public WebServiceSample() {
	}

	@WebMethod
	public String registraPeticion(String peticion) {
		// aqui se puede hacer el llamado a clases de apoyo
		return "Se ha registrado la peticion " + peticion + "correctamente.";
	}
}
