package com.boot.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.boot.model.Person;

public interface PersonReposity extends CrudRepository<Person,Long>{
	@Transactional
	@Modifying
	@Query(value="delete from person where sno=:sno",nativeQuery = true)
	public void deleteBySno(@Param("sno") Integer sno);
	
}
