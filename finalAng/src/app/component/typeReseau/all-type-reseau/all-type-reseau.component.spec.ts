import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllTypeReseauComponent } from './all-type-reseau.component';

describe('AllTypeReseauComponent', () => {
  let component: AllTypeReseauComponent;
  let fixture: ComponentFixture<AllTypeReseauComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AllTypeReseauComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AllTypeReseauComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
