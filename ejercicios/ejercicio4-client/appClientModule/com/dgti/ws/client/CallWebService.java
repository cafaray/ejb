package com.dgti.ws.client;

import com.dgti.ws.RegistraArtista_Service;
import com.dgti.ws.RegsitraArtista;

public class CallWebService {

	public static void main(String[] args) {
		RegistraArtista_Service service = new RegistraArtista_Service();
		RegsitraArtista port = service.getRegsitraArtistaPort();

		String nombre = "Juanito Bananas";
		int result = port.registraArtista(nombre);
		System.out.println("Result = " + result);
	}

}
