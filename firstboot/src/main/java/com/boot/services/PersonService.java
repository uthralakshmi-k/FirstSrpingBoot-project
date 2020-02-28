package com.boot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.model.Person;
import com.boot.repositories.PersonReposity;

@Service
public class PersonService {
	@Autowired
	PersonReposity prepo;
	
	public List<Person> getPeople()
	{
		return (List<Person>)prepo.findAll();
	}
	
	public void putPerson(Person p) {
		prepo.save(p);
	}
	public void updatePerson(Person p) {
		prepo.save(p);
	}
	
	public void removePerson(Person p) {
		prepo.delete(p);
	}
	
	public void removePerson(Integer sno) {
		prepo.deleteBySno(sno);
	}

}
