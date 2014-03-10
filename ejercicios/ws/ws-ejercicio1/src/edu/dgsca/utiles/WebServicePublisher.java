package edu.dgsca.utiles;

import javax.xml.ws.Endpoint;

import edu.dgsca.ws.endpoint.WebServiceSample;

public class WebServicePublisher {

	public static void main(String[] args) {

		Endpoint ep = Endpoint.create(new WebServiceSample());
		if (!ep.isPublished()) {
			Endpoint endPoint = Endpoint.publish(
					"http://localhost:7777/wssample", new WebServiceSample());
			System.out.println("El servicio ha sído publicado: "
					+ endPoint.isPublished());
		}else{
			ep.stop();
		}
	}

}
