package br.com.mfsdevsystem.citiesapi.dto;

import java.io.Serializable;

import javax.persistence.Column;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.data.geo.Point;

import br.com.mfsdevsystem.citiesapi.model.City;
import br.com.mfsdevsystem.citiesapi.model.PointType;
import br.com.mfsdevsystem.citiesapi.model.State;

@TypeDefs(value = {
		@TypeDef(name = "point", typeClass = PointType.class)
	})
public class CityDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	// private Integer uf;
	private State uf;
	private Integer ibge;
	// 1st
	private String geoLocation;
	
	// 2st
	@Type(type = "point")
	@Column(name = "lat_lon")
	private Point location;
	
	public CityDTO(Long id, String name, State uf, Integer ibge, String geoLocation, Point location) {
		this.id = id;
		this.name = name;
		this.uf = uf;
		this.ibge = ibge;
		this.geoLocation = geoLocation;
		this.location = location;
	}

	
	
	public CityDTO(City entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.uf = entity.getUf();
		this.ibge = entity.getIbge();
		this.geoLocation = entity.getGeoLocation();
		this.location = entity.getLocation();
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
	
	

	public State getUf() {
		return uf;
	}

	public void setUf(State uf) {
		this.uf = uf;
	}

	/*
	public Integer getUf() {
		return uf;
	}

	public void setUf(Integer uf) {
		this.uf = uf;
	}
*/
	public Integer getIbge() {
		return ibge;
	}

	public void setIbge(Integer ibge) {
		this.ibge = ibge;
	}

	public String getGeoLocation() {
		return geoLocation;
	}

	public void setGeoLocation(String geoLocation) {
		this.geoLocation = geoLocation;
	}

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point location) {
		this.location = location;
	}
	
}
