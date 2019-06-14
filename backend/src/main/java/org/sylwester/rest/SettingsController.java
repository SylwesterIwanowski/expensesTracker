package org.sylwester.rest;

import static com.google.common.collect.Lists.newArrayList;
import static org.sylwester.util.Utils.calculateDaysTillDate;
import static org.sylwester.util.Utils.getDate;
import static org.sylwester.util.Utils.mapNonNullProperties;

import java.util.Date;
import java.util.List;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.sylwester.model.UserSettings;
import org.sylwester.model.dto.UserSettingsDTO;
import org.sylwester.repository.ExpenseRepository;
import org.sylwester.repository.SettingsRepository;

@Controller
@RequestMapping(path = "rest/api/settings")
public class SettingsController {

	@Autowired
	private SettingsRepository settingsRepository;

	@Autowired
	private ExpenseRepository expenseRepository;

	@PostMapping
	public @ResponseBody UserSettingsDTO changeSettings(@RequestBody UserSettings changeSettings) {
		validateSettings(changeSettings);
		UserSettings currentSettings = getOrCreateSettings();
		mapNonNullProperties(currentSettings, changeSettings);
		settingsRepository.save(currentSettings);
		return mapSettingsToDTO(currentSettings);
	}

	private void validateSettings(UserSettings settings) {
		if (!isDateGreaterOrEqualThanToday(settings.getEndDayOfBudget())) {
			throw new ValidationException("End of the budget cannot be in the past");
		}
	}

	private UserSettingsDTO mapSettingsToDTO(UserSettings settings) {
		UserSettingsDTO dtoSettings = new UserSettingsDTO();
		mapNonNullProperties(dtoSettings, settings);
		int amortization = calculateAmortization(settings);
		dtoSettings.setAmortization(amortization);
		dtoSettings.setSpentToday(calculateTodayExpenses());
		return dtoSettings;
	}

	private int calculateTodayExpenses() {
		return newArrayList(expenseRepository.findAll()).stream()
			.filter(expense -> isDateToday(expense.getDate()))
			.map(expense -> expense.getAmount())
			.reduce(0, (a, b) -> a + b);
	}

	private int calculateAmortization(UserSettings settings) {
		Integer daysToSurvive = calculateDaysTillDate(settings.getEndDayOfBudget());
		Integer moneyToSpend = settings.getDailyLimit() * daysToSurvive;
		Integer moneySpentToday = calculateTodayExpenses();
		Integer todaySpentTooMuch = Math.max(moneySpentToday - settings.getDailyLimit(), 0);
		return settings.getAccountBalance() + moneySpentToday - todaySpentTooMuch - moneyToSpend;
	}

	private boolean isDateGreaterOrEqualThanToday(Date date) {
		return calculateDaysTillDate(date) >= 1;
	}

	private boolean isDateToday(Date date) {
		return calculateDaysTillDate(date) == 1;
	}

	@GetMapping
	public @ResponseBody UserSettingsDTO getSettings() {
		UserSettings userSettings = getOrCreateSettings();
		return mapSettingsToDTO(userSettings);
	}

	private UserSettings getOrCreateSettings() {
		List<UserSettings> settings = newArrayList(settingsRepository.findAll());
		if (settings.isEmpty()) {
			UserSettings createdSettings = createSettings();
			settingsRepository.save(createdSettings);
			return createdSettings;
		}
		return newArrayList(settingsRepository.findAll()).get(0);
	}

	private UserSettings createSettings() {
		UserSettings settings = new UserSettings();
		settings.setAccountBalance(0);
		settings.setDailyLimit(50);
		settings.setStartDayOfBudget(getDate(2019, 5, 24));
		settings.setEndDayOfBudget(getDate(2019, 6, 25));
		return settings;
	}
}
