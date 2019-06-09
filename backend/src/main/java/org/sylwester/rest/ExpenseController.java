package org.sylwester.rest;

import java.util.Date;

import org.sylwester.model.UserExpense;
import org.sylwester.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "rest/api/expense")
public class ExpenseController {

	@Autowired
	private ExpenseRepository expenseRepository;

	@PostMapping
	public @ResponseBody UserExpense addExpense(@RequestBody UserExpense expense) {
		expense.setId(null);
		expense.setDate(new Date());
		expenseRepository.save(expense);
		return expense;
	}

	@GetMapping
	public @ResponseBody Iterable<UserExpense> getAllExpenses() {
		return expenseRepository.findAll();
	}
}
