import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreationTypereseauComponent } from './creation-typereseau.component';

describe('CreationTypereseauComponent', () => {
  let component: CreationTypereseauComponent;
  let fixture: ComponentFixture<CreationTypereseauComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreationTypereseauComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreationTypereseauComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
