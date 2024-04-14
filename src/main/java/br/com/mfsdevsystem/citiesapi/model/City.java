package br.com.mfsdevsystem.citiesapi.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.data.geo.Point;

@Entity
@Table(name = "cidade")
@TypeDefs(value = {
	@TypeDef(name = "point", typeClass = PointType.class)
})
public class City implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	
	@Column(name = "nome")
	private String name;
	

	@ManyToOne
    @JoinColumn(name = "uf", referencedColumnName = "id")
	private State uf;
	//private Integer uf;
	
	private Integer ibge;
	
	// 1st
	@Column(name="lat_lon")
	private String geoLocation;
	
	// 2st
    
	 @Type(type = "point")
	 @Column(name = "lat_lon", updatable = false, insertable = false)
	 private Point location;

	

	public City(Long id, String name, State uf, Integer ibge, String geoLocation, Point location) {
		this.id = id;
		this.name = name;
		this.uf = uf;
		this.ibge = ibge;
		this.geoLocation = geoLocation;
		this.location = location;
	}

	public City() {

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
		City other = (City) obj;
		return Objects.equals(id, other.id);
	}

	
}
