import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AppSettingsService {

  getBackendDns(): string {
    return 'localhost';
  }

  getBackendUrl(): string {
    return 'http://' + this.getBackendDns() + ':8080';
  }

  getBackendEndpoint(endpoint: string): string {
    return this.getBackendUrl() + '/rest/api/' + endpoint;
  }

  constructor() { }
}
