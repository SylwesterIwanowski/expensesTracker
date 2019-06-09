import { Component, OnInit } from '@angular/core';
import {Expense} from '../expense';
import {ExpenseService} from '../expense.service';
import {Settings} from '../settings';
import {SettingsService} from '../settings.service';

@Component({
  selector: 'app-daily-budget',
  templateUrl: './daily-budget.component.html',
  styleUrls: ['./daily-budget.component.css']
})
export class DailyBudgetComponent implements OnInit {

  expense: Expense = {
    id: null,
    amount: 0,
    description: '',
    date: null
  };

  settings: Settings;

  addExpense(): void {
    this.expenseService.addExpense(this.expense)
      .subscribe(expense => {
      this.settings.accountBalance -= expense.amount;
      this.settingsService.settingsSave(this.settings)
        .subscribe(settings => this.settings = settings);
      this.expense.amount = 0;
      this.expense.description = '';
      this.expense.date = null;
      this.expense.id = null;
    });
  }

  initializeSettings() {
    this.settingsService.settingsGetRequest()
      .subscribe(settings => this.settings = settings);
  }

  constructor(private expenseService: ExpenseService, private settingsService: SettingsService) { }

  ngOnInit() {
    this.initializeSettings();
  }

}
