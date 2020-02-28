
package com.boot.repositories;

import org.springframework.data.repository.CrudRepository;

import com.boot.model.User;

public interface UserDAO extends CrudRepository<User, Long>{

	public User getUserByUsername(String username);
}
