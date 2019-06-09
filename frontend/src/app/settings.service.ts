import { Injectable } from '@angular/core';
import {Settings} from './settings';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class SettingsService {

  private settingsUrl = 'http://localhost:8080/rest/api/settings';

  settingsGetRequest(): Observable<Settings> {
    return this.http.get<Settings>(this.settingsUrl);
  }

  settingsSave(settings: Settings): Observable<Settings> {
    return this.http.post<Settings>(this.settingsUrl, settings, httpOptions);
  }

  constructor(private http: HttpClient) { }
}
