import { TypereseauValidator } from './../validator/typereseau-validator';
import { Router, ActivatedRoute } from '@angular/router';
import { TypeReseauService } from './../../services/type-reseau.service';
import { Observable } from 'rxjs';
import { TypeReseau } from './../../model/type-reseau';
import { FormGroup, Validators, FormControl } from '@angular/forms';
import { Component } from '@angular/core';

@Component({
  selector: 'app-creation-typereseau',
  templateUrl: './creation-typereseau.component.html',
  styleUrls: ['./creation-typereseau.component.css'],
})
export class CreationTypereseauComponent {
  form!: FormGroup;

  typeReseau: TypeReseau = new TypeReseau();
  obsTypeReseaux!: Observable<TypeReseau[]>;

  gomme = '';
  ajouteSuccess = '';

  constructor(
    private trService: TypeReseauService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.obsTypeReseaux = this.trService.getAll();

    this.form = new FormGroup({
      idTypeReseau: new FormControl(
        '',
        Validators.required,
        TypereseauValidator.checkIdExist(this.trService)
      ),
      libelle: new FormControl('', Validators.required),
    });
    //j'ai chargé le parmametre que j'ai recuperer dans typereseau2
  }

  save() {
    if (confirm('Etes-vous certain de créer ce type réseau ') == true) {
      this.creation();
    } else {
      this.goTypeReseau;
    }
  }
  creation() {
    this.trService
      .create({
        idTypeReseau: this.form.get('idTypeReseau')?.value,
        libelle: this.form.get('libelle')?.value,
        reseau: undefined,
        rejet: undefined,
        dateDerniereModification: undefined,
      })
      .subscribe(() => {
        this.ajouteSuccess = 'Ajout effectué avec succès';
        this.router.navigateByUrl('/typereseau/modification?creation=ok');
      });
    console.log(this.ajouteSuccess);
  }

  goTypeReseau() {
    this.router.navigateByUrl('/typereseau/cration');
  }

  effacer() {
    this.typeReseau.idTypeReseau = undefined;
    this.typeReseau.libelle = undefined;
  }
}
