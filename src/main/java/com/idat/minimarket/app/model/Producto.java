package com.idat.minimarket.app.model;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name = "productos")
public class Producto implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private Integer id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "precio")
	private Double precio;
	@Column(name = "cantidad")
	private Integer cantidad;
	@Column(name = "marca")
	private String marca;
	@Column(name = "url")
	private String url;
	@JoinColumn(name = "categoria", referencedColumnName = "id")
	@ManyToOne
	private Categoria categoria;
	
	public Producto() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Producto(Integer id, String nombre, Double precio, Integer cantidad, String marca, String url) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
		this.marca = marca;
		this.url = url;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	
}
