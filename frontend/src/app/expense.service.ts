import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Expense} from './expense';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class ExpenseService {

  private expenseUrl = 'http://localhost:8080/rest/api/expense';

  getAllExpenses(): Observable<Expense> {
    return this.http.get<Expense>(this.expenseUrl);
  }

  addExpense(expense: Expense): Observable<Expense> {
    return this.http.post<Expense>(this.expenseUrl, expense, httpOptions);
  }

  constructor(private http: HttpClient) { }
}
