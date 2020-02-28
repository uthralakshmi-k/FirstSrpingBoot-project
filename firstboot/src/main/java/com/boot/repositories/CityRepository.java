package com.boot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.boot.model.City;


public interface CityRepository extends CrudRepository<City,Long> {

	@Query("from City where lower(name) like :pattern")
	public List<City> getCities(@Param("pattern")String pattern);
	
	public List<City> getCityByCountrycode(String countrycode);
}
