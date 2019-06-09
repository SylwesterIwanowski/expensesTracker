package org.sylwester.repository;

import org.sylwester.model.UserExpense;
import org.springframework.data.repository.CrudRepository;

public interface ExpenseRepository extends CrudRepository<UserExpense, Integer> {

}
