import { Injectable } from '@angular/core';
import {Settings} from './settings';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {AppSettingsService} from './app-settings.service';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class SettingsService {

  private settingsEndpoint = 'settings';

  getEndpoint(): string {
    return this.appSettings.getBackendEndpoint(this.settingsEndpoint);
  }

  settingsGetRequest(): Observable<Settings> {
    return this.http.get<Settings>(this.getEndpoint());
  }

  settingsSave(settings: Settings): Observable<Settings> {
    return this.http.post<Settings>(this.getEndpoint(), settings, httpOptions);
  }

  constructor(private http: HttpClient, private appSettings: AppSettingsService) { }
}
