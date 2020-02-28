package com.boot.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.model.City;
import com.boot.repositories.CityRepository;

@Service
public class DataService {
	@Autowired
	CityRepository cityrepo;

	public Map<String, String[]> names() {
		String[] names = { "Nirmal", "Harry", "Johny", "Preveen", "raju" };
		String[] names2 = { "Shan", "Johan", "Paul" };
		Map<String, String[]> map = new HashMap<String, String[]>();
		map.put("team1", names);
		map.put("team2", names2);

		return map;
	}
	public List<City> getCity(String countrycode){
		return  cityrepo.getCityByCountrycode(countrycode);
		
	}

	public List<City> getCity() {
		return (List<City>) cityrepo.findAll();
	}

	public List<City> getCities(String pattern)
	{
		return cityrepo.getCities("%"+pattern.toLowerCase()+"%");
	}

}
