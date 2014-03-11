package edu.dgsca.ejb.sfsb.interfaces;

import java.util.List;

import javax.ejb.Remote;

import edu.dgsca.ejb.exceptions.CargaFacturaException;
import edu.dgsca.ejb.modelo.FacturaCabecera;

@Remote
public interface CargaFacturasRemote {
	public FacturaCabecera ingresaFactura(FacturaCabecera factura) throws CargaFacturaException;
	public void quitaFactura(FacturaCabecera factura) throws CargaFacturaException;
	public List<FacturaCabecera> listaFacturas() throws CargaFacturaException;
	public void remove();
}
