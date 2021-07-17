package com.idat.minimarket.app.service;

import java.util.List;

import com.idat.minimarket.app.dao.FacturaCompraDao;
import com.idat.minimarket.app.dao.ProductoDao;
import com.idat.minimarket.app.model.FacturaCompra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FacturaCompraServicio {

    @Autowired
	private FacturaCompraDao repositorioFac;

    @Autowired
	private ProductoDao repositorioPro;


	public List<FacturaCompra> findFacturas() {
		return (List<FacturaCompra>) repositorioFac.findAll();
	}

	public FacturaCompra findFacturaById(Integer codigo) {
		return repositorioFac.findById(codigo).orElse(null);
	}
	
	public FacturaCompra saveFactura(FacturaCompra facturaCompra) {
		return repositorioFac.save(facturaCompra);
	}

	public void deleteFacturaById(Integer codigo) {
		repositorioFac.deleteById(codigo);
	};

	public FacturaCompra actualizar(FacturaCompra facturaCompra) {

		FacturaCompra actualFacturaCompra = repositorioFac.findById(facturaCompra.getCodigo()).get();
	
        actualFacturaCompra.setEstado(facturaCompra.getEstado());

		return repositorioFac.save(actualFacturaCompra);
	} 

	public FacturaCompra update(FacturaCompra facturaCompra){
		FacturaCompra nuevo = repositorioFac.save(facturaCompra);
		return nuevo;
	}




	
    
}
