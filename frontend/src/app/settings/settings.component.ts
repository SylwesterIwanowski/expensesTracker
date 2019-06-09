import { Component, OnInit } from '@angular/core';
import {SettingsService} from '../settings.service';
import {Settings} from '../settings';

@Component({
  selector: 'app-settings',
  templateUrl: './settings.component.html',
  styleUrls: ['./settings.component.css']
})
export class SettingsComponent implements OnInit {

  public settings: Settings;

  setSettings(): void {
    this.settingsService.settingsGetRequest()
      .subscribe(settings => {
        this.settings = settings;
        console.log(settings);
        console.log('xd');
      });
  }

  saveSettings(): void {
    this.settingsService.settingsSave(this.settings)
      .subscribe(settings => {
        this.settings = settings;
        console.log('xd1');
        console.log(settings);
        console.log('xd2');
      });
  }

  constructor(private settingsService: SettingsService) { }

  ngOnInit() {
    this.setSettings();
  }

}
