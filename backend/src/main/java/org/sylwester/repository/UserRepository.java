package org.sylwester.repository;

import org.sylwester.model.ApplicationUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<ApplicationUser, Integer> {

}
