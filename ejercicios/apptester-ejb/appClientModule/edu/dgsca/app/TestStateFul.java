package edu.dgsca.app;

import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import edu.dgsca.ejb.exceptions.CargaFacturaException;
import edu.dgsca.ejb.modelo.FacturaCabecera;
import edu.dgsca.ejb.sfsb.interfaces.CargaFacturasRemote;

public class TestStateFul {

	public TestStateFul() {}

	public static void main(String[] args) {
		try {
			Context ctx = getContext();						
			CargaFacturasRemote cargaFacturas  = (CargaFacturasRemote)ctx.lookup("CargaFacturas");
			
			FacturaCabecera factura = new FacturaCabecera();
			factura.setEmisor("YOMERO");
			factura.setRfc("YOMERO9999999");
			factura.setTotal(1310);
			factura.setSubtotal(1239);
			factura.setIva(factura.getTotal()-factura.getSubtotal());
			cargaFacturas.ingresaFactura(factura);
			System.out.println("La factura se genero correctamente: "
					+ factura.toString());
			factura = new FacturaCabecera();
			factura.setEmisor("TUMERO");
			factura.setRfc("TUMERO9999999");
			factura.setTotal(1160);
			factura.setSubtotal(1000);
			factura.setIva(factura.getTotal()-factura.getSubtotal());
			cargaFacturas.ingresaFactura(factura);
			System.out.println("La factura se genero correctamente: "
					+ factura.toString());
			factura = new FacturaCabecera();
			factura.setEmisor("ELMERO");
			factura.setRfc("ELMERO9999999");
			factura.setTotal(2320);
			factura.setSubtotal(2000);
			factura.setIva(factura.getTotal()-factura.getSubtotal());
			cargaFacturas.ingresaFactura(factura);
			System.out.println("La factura se genero correctamente: "
					+ factura.toString());
			List<FacturaCabecera> facturas = cargaFacturas.listaFacturas();
			for(FacturaCabecera f:facturas){
				System.out.printf("Factura de %s por un total de %.2f%n",f.getEmisor(), f.getTotal());
			}
			cargaFacturas.remove();
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (CargaFacturaException e) {
			e.printStackTrace();
		}	
	}

	private static Context getContext() throws NamingException{
		Properties props = new Properties();
		props.put(Context.INITIAL_CONTEXT_FACTORY,
				"org.jnp.interfaces.NamingContextFactory");
		props.put(Context.PROVIDER_URL, "jnp://localhost:1099");
		props.put(InitialContext.URL_PKG_PREFIXES,
				"org.jboss.naming:org.jnp.interfaces");
		Context ctx = new InitialContext(props);
		return ctx;
	}
	
}
