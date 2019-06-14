import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Expense} from './expense';
import {AppSettingsService} from './app-settings.service';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class ExpenseService {

  private expenseEndpoint = 'expense';

  getEndpoint(): string {
    return this.appSettings.getBackendEndpoint(this.expenseEndpoint);
  }

  getAllExpenses(): Observable<Expense> {
    return this.http.get<Expense>(this.getEndpoint());
  }

  addExpense(expense: Expense): Observable<Expense> {
    return this.http.post<Expense>(this.getEndpoint(), expense, httpOptions);
  }

  constructor(private http: HttpClient, private appSettings: AppSettingsService) { }
}
