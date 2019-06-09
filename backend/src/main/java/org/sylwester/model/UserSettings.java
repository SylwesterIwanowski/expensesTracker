package org.sylwester.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserSettings {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	Integer accountBalance;

	Integer dailyLimit;

	Date startDayOfBudget;

	Date endDayOfBudget;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Integer accountBalance) {
		this.accountBalance = accountBalance;
	}

	public Integer getDailyLimit() {
		return dailyLimit;
	}

	public void setDailyLimit(Integer dailyLimit) {
		this.dailyLimit = dailyLimit;
	}

	public Date getStartDayOfBudget() {
		return startDayOfBudget;
	}

	public void setStartDayOfBudget(Date startDayOfBudget) {
		this.startDayOfBudget = startDayOfBudget;
	}

	public Date getEndDayOfBudget() {
		return endDayOfBudget;
	}

	public void setEndDayOfBudget(Date endDayOfBudget) {
		this.endDayOfBudget = endDayOfBudget;
	}
}
