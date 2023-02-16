import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModifierTypereseauComponent } from './modifier-typereseau.component';

describe('ModifierTypereseauComponent', () => {
  let component: ModifierTypereseauComponent;
  let fixture: ComponentFixture<ModifierTypereseauComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModifierTypereseauComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ModifierTypereseauComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
