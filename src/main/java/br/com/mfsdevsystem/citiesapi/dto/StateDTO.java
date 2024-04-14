package br.com.mfsdevsystem.citiesapi.dto;

import java.io.Serializable;
import java.util.List;

import br.com.mfsdevsystem.citiesapi.model.Country;
import br.com.mfsdevsystem.citiesapi.model.State;

public class StateDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String uf;
	private Integer ibge;

	// 1st
	//private Integer countryId;

	// 2nd - @ManyToOne
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "pais", referencedColumnName = "id") 
	 
	 */
	private Country country;
/*
	@Type(JsonType.class)
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "ddd", columnDefinition = "jsonb")
*/
	private List<Integer> ddd;

	public StateDTO() {
	}

    //	public StateDTO(Long id, String name, String uf, Integer ibge, Integer countryId, List<Integer> ddd) {
	public StateDTO(Long id, String name, String uf, Integer ibge, Country country, List<Integer> ddd) {

		this.id = id;
		this.name = name;
		this.uf = uf;
		this.ibge = ibge;
		this.country = country;
		this.ddd = ddd;
	}

	public StateDTO(State entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.uf = entity.getUf();
		this.ibge = entity.getIbge();
		this.country = entity.getCountry();
		this.ddd = entity.getDdd();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getUf() {
		return uf;
	}

	public Integer getIbge() {
		return ibge;
	}

	public List<Integer> getDdd() {
		return ddd;
	}

	
	public Country getCountry() { 
		return country;
	}
	
	/*public Integer getCountryId() {
		return countryId;
	}
	*/
}
