package br.com.mfsdevsystem.citiesapi.dto;

import java.io.Serializable;

import br.com.mfsdevsystem.citiesapi.model.Country;

public class CountryDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;	
	private String portugueseName;
	private String code;
	private Integer bacen;

	public CountryDTO() {
		
	}
	
	public CountryDTO(Long id, String name, String portugueseName, String code, Integer bacen) {
		this.id = id;
		this.name = name;
		this.portugueseName = portugueseName;
		this.code = code;
		this.bacen = bacen;
	}
	
	public CountryDTO(Country entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.portugueseName = entity.getPortugueseName();
		this.code = entity.getCode();
		this.bacen = entity.getBacen();
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

	public void setPortugueseName(String portugueseName) {
		this.portugueseName = portugueseName;
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
	
	

}
