import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsultationTypereseauComponent } from './consultation-typereseau.component';

describe('ConsultationTypereseauComponent', () => {
  let component: ConsultationTypereseauComponent;
  let fixture: ComponentFixture<ConsultationTypereseauComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ConsultationTypereseauComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ConsultationTypereseauComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
