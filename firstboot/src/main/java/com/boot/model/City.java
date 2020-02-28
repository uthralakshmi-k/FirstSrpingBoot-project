
package com.boot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class City {
	@Id
	private Integer id;

	@Column
	private String name;
	
	@Column
	private String countrycode;
	

	@Column
	private String district;
	
	@Column
	private String population;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountycode() {
		return countrycode;
	}

	public void setCountycode(String countycode) {
		this.countrycode = countycode;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getPopulation() {
		return population;
	}

	public void setPopulation(String population) {
		this.population = population;
	}

	
	
}
