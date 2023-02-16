import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { TypeReseauService } from './../../services/type-reseau.service';

import { TypeReseau } from './../../model/type-reseau';
import { Component } from '@angular/core';

@Component({
  selector: 'app-consultation-typereseau',
  templateUrl: './consultation-typereseau.component.html',
  styleUrls: ['./consultation-typereseau.component.css'],
})
export class ConsultationTypereseauComponent {
  libelle = '';

  typeReseau: TypeReseau = new TypeReseau();

  obsTypeReseaux!: Observable<TypeReseau[]>;
  pageNumber = 0;
  gomme = '';
  constructor(
    private typeReseauSer: TypeReseauService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.obsTypeReseaux = this.typeReseauSer.getAll();
  }

  recherche() {
    if (this.typeReseau.libelle) {
      this.router.navigateByUrl(
        `/typereseau/libelle/${this.typeReseau.libelle}`
      );
    }
    // } else {
    //   this.router.navigateByUrl(`/typereseau/${this.typeReseau.idTypeReseau}`);
    // }
  }
  effacer() {
    this.typeReseau.libelle = '';
    this.typeReseau.idTypeReseau = undefined;
  }
}
