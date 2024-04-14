package br.com.mfsdevsystem.citiesapi.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="Country")
@Table(name="pais")
public class Country implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	
	@Column(name="nome")
	private String name;
	
	@Column(name="nome_pt")
	private String portugueseName;
	
	@Column(name="sigla")
	private String code;
	
	private Integer bacen;

	public Country() {
		
	}
	
	public Country(Long id, String name, String portugueseName, String code, Integer bacen) {
		this.id = id;
		this.name = name;
		this.portugueseName = portugueseName;
		this.code = code;
		this.bacen = bacen;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getPortugueseName() {
	    return portugueseName;
	  }

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getBacen() {
		return bacen;
	}

	public void setBacen(Integer bacen) {
		this.bacen = bacen;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
