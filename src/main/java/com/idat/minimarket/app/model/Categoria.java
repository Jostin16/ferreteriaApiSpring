package com.idat.minimarket.app.model;
 
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
 
@Entity
@Table(name = "categorias")
public class Categoria implements Serializable {
 
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;
    @Column
    private String descripcion;
    @Column
    private String url;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoria",fetch=FetchType.LAZY)
    @JsonBackReference(value="prod_cat")
    private List<Producto> productoList;
 
    public Categoria() {
        super();
    }
 
    public Categoria(Integer id, String descripcion, String url) {
        super();
        this.id = id;
        this.descripcion = descripcion;
        this.url = url;
    }
 
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
        return descripcion;
    }
 
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
 
    public String getUrl() {
        return url;
    }
 
    public void setUrl(String url) {
        this.url = url;
    }

	public List<Producto> getProductoList() {
		return productoList;
	}

	public void setProductoList(List<Producto> productoList) {
		this.productoList = productoList;
	}
    

}
