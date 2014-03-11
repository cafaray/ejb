package edu.dgsca.ejb.sfsb;

import java.util.ArrayList;
import java.util.List;

import edu.dgsca.ejb.exceptions.CargaFacturaException;
import edu.dgsca.ejb.modelo.FacturaCabecera;
import edu.dgsca.ejb.sfsb.interfaces.CargaFacturasRemote;

import javax.ejb.Remove;
import javax.ejb.Stateful;

import org.jboss.ejb3.annotation.RemoteBinding;

@RemoteBinding(jndiBinding="CargaFacturas")
@Stateful
public class CargaFacturas implements CargaFacturasRemote {

	List<FacturaCabecera> facturas;
    public CargaFacturas() {
        System.out.println("Se creo el componente de sesion para carga de facturas");
        facturas = new ArrayList<FacturaCabecera>();
    }

	@Override
	public FacturaCabecera ingresaFactura(FacturaCabecera factura)
			throws CargaFacturaException {
		facturas.add(factura);
		return factura;
	}

	@Override
	public void quitaFactura(FacturaCabecera factura)
			throws CargaFacturaException {
		if (facturas.contains(factura)){
			facturas.remove(factura);
		}else{
			throw new CargaFacturaException(String.format("La factura con serie %s y folio %s no existe en el listado.",factura.getSerie(), factura.getFolio()));
		}
	}

	@Override
	public List<FacturaCabecera> listaFacturas() throws CargaFacturaException {		
		return facturas;
	}
	
    @Remove
    public void remove(){
    	facturas = null;
    	System.out.println("Se destruyol el componente de sesion para carga de facturas");
    }
    
}
