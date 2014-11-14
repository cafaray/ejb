package com.dgti.ws.clientsample;

import com.dgti.ws.*;

public class ClientSample {

	public static void main(String[] args) {
	        System.out.println("***********************");
	        System.out.println("Create Web Service Client...");
	        RegistraArtista_Service service1 = new RegistraArtista_Service();
	        System.out.println("Create Web Service...");
	        RegsitraArtista port1 = service1.getRegsitraArtistaPort();
	        System.out.println("Call Web Service Operation...");
	        System.out.println("Server said: " + port1.registraArtista(null));
	        //Please input the parameters instead of 'null' for the upper method!
	
	        System.out.println("Create Web Service...");
	        RegsitraArtista port2 = service1.getRegsitraArtistaPort();
	        System.out.println("Call Web Service Operation...");
	        System.out.println("Server said: " + port2.registraArtista(null));
	        //Please input the parameters instead of 'null' for the upper method!
	
	        System.out.println("***********************");
	        System.out.println("Call Over!");
	}
}
