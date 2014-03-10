package edu.dgsca.samples;

import edu.dgsca.ws.cliente.WebServiceSample;
import edu.dgsca.ws.cliente.WebServiceSample_Service;

public class TestWebService {

	public static void main(String[] args) {
		
		WebServiceSample_Service service = new WebServiceSample_Service();
		WebServiceSample ws = service.getWebServiceSamplePort();
		String respuesta = ws.registraPeticion("RegistroPersona");
		System.out.println("La respuesta del servicio es: \n"+respuesta);
	}

}
