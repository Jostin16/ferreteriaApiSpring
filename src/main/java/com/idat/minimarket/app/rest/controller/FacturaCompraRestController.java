package com.idat.minimarket.app.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.idat.minimarket.app.model.DetalleCompra;
import com.idat.minimarket.app.model.FacturaCompra;
import com.idat.minimarket.app.service.FacturaCompraServicio;
import com.idat.minimarket.app.service.ProductoService;


@RestController
@RequestMapping("/rest")
public class FacturaCompraRestController {
	
	@Autowired
	private FacturaCompraServicio servicio;

	@Autowired
	private ProductoService servicioProducto;
	
	@GetMapping("/facturas")
	public ResponseEntity<Object> listar(){
		List<FacturaCompra> listaFacturaCompra = servicio.findFacturas();
        return new ResponseEntity<Object>(listaFacturaCompra, HttpStatus.OK);
	}

	
	@GetMapping("/facturas/{codigo}")
	@ResponseStatus(code = HttpStatus.OK)
	public FacturaCompra mostrar(@PathVariable Integer codigo) {
		return servicio.findFacturaById(codigo);
	}	

	@DeleteMapping(value = "/comprar/{codigo}")
	public ResponseEntity<Object> comprar(@PathVariable("codigo") Integer codigo)
	{
		FacturaCompra facturaCompra = servicio.findFacturaById(codigo);
		 
		 if (facturaCompra == null)
			 throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Factura de compra no encontrada");
		
		servicio.actualizar(facturaCompra);

		List<DetalleCompra> lDetalleFacCompra = facturaCompra.getlDetalleCompra();
		for(int indice = 0; indice<lDetalleFacCompra.size();indice++){

			servicioProducto.disminuirStock(lDetalleFacCompra.get(indice).getProducto().getId(), lDetalleFacCompra.get(indice).getCantidad());

		}
		return new ResponseEntity<Object>("Compra exitosa", HttpStatus.OK);
	}

	
	@PostMapping("/facturas")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Object> crear(@RequestBody FacturaCompra facturaCompra){

		List<DetalleCompra> lDetalleFacCompra = facturaCompra.getlDetalleCompra();
		servicio.saveFactura(facturaCompra);
		for(int indice = 0; indice<lDetalleFacCompra.size();indice++){

			servicioProducto.aumentarStock(lDetalleFacCompra.get(indice).getProducto().getId(), lDetalleFacCompra.get(indice).getCantidad());

		}

		return new ResponseEntity<Object>("Factura compra creada correctamente", HttpStatus.OK);
	}


}