import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TypeReseauComponent } from './type-reseau.component';

describe('TypeReseauComponent', () => {
  let component: TypeReseauComponent;
  let fixture: ComponentFixture<TypeReseauComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TypeReseauComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TypeReseauComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
