package org.sylwester.model.dto;


import java.util.Date;


public class UserSettingsDTO {

	private Integer id;

	Integer accountBalance;

	Integer dailyLimit;

	Date startDayOfBudget;

	Date endDayOfBudget;

	Integer amortization;

	Integer spentToday;

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

	public Integer getAmortization() {
		return amortization;
	}

	public void setAmortization(Integer amortization) {
		this.amortization = amortization;
	}

	public Integer getSpentToday() {
		return spentToday;
	}

	public void setSpentToday(Integer spentToday) {
		this.spentToday = spentToday;
	}
}
