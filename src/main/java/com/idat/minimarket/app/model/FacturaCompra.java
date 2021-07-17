package com.idat.minimarket.app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name = "factura_compra")
public class FacturaCompra implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Integer codigo;

	@Column(name = "fecha")
	@Temporal(TemporalType.DATE)
	private Date fecha;

	
	@Column(name = "descripcion", length = 30)
	private String descripcion;

	@Column(name = "observaciones", length = 30)
	private String observaciones;

	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "idFCompra")
	private List<DetalleCompra> lDetalleCompra;


	@Column(length = 20)
	private String estado = "HABILITADO";

	public FacturaCompra(){
		lDetalleCompra=new ArrayList<>();
	}


	@PrePersist
	public void insertarFecha() {
		this.fecha = new Date();
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}



	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	


	public Double getTotal(){
		Double total=0.00;
		for(DetalleCompra dt: lDetalleCompra){
			total+=dt.getImporte();
		}
		return total;
	}

	public List<DetalleCompra> getlDetalleCompra() {
		return lDetalleCompra;
	}


	public void setlDetalleCompra(List<DetalleCompra> lDetalleCompra) {
		this.lDetalleCompra = lDetalleCompra;
	}


	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
}
