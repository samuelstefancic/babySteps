import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RechercheTypeReseauComponent } from './recherche-type-reseau.component';

describe('RechercheTypeReseauComponent', () => {
  let component: RechercheTypeReseauComponent;
  let fixture: ComponentFixture<RechercheTypeReseauComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RechercheTypeReseauComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RechercheTypeReseauComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
