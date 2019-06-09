import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DailyBudgetComponent } from './daily-budget.component';

describe('DailyBudgetComponent', () => {
  let component: DailyBudgetComponent;
  let fixture: ComponentFixture<DailyBudgetComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DailyBudgetComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DailyBudgetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
