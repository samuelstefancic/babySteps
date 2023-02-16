import { TestBed } from '@angular/core/testing';

import { TypeReseauService } from './type-reseau.service';

describe('TypeReseauService', () => {
  let service: TypeReseauService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TypeReseauService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
