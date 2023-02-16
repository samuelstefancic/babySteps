import { TypereseauValidator } from './../../validator/typereseau-validator';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { TypeReseauService } from './../../../services/type-reseau.service';
import { Observable } from 'rxjs';
import { TypeReseau } from './../../../model/type-reseau';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-type-reseau',
  templateUrl: './type-reseau.component.html',
  styleUrls: ['./type-reseau.component.css'],
})
export class TypeReseauComponent implements OnInit {
  form!: FormGroup;
  //pour créer un nouvel typeReseau
  typeReseau: TypeReseau = new TypeReseau();
  //pour chercher l'id param,
  //j'ai utilisé 2 pour passer par le if et else
  typeReseau2: TypeReseau = new TypeReseau();
  obsTypeReseaux!: Observable<TypeReseau[]>;
  //qui va effacer l'input idTypeReseau
  gomme = '';
  //si on a une creation
  ajouteSuccess = '';
  //update info
  modification = '';

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
      idTypeReseau2: new FormControl('', undefined),
    });
    //j'ai chargé le parmametre que j'ai recuperer dans typereseau2
    this.activatedRoute.params.subscribe((params) => {
      if (params['idTypeReseau']) {
        this.trService
          .getById(params['idTypeReseau'])
          .subscribe((typeReseau2) => {
            this.typeReseau2 = typeReseau2;
          });
      }
    });
  }

  save() {
    if (confirm('vous etes sur!') == true) {
      if (this.typeReseau2.idTypeReseau) {
        this.update();
      } else {
        this.creation();
      }
    } else {
      this.goTypeReseau;
    }
  }

  update() {
    this.trService
      .update({
        idTypeReseau: this.form.get('idTypeReseau')?.value,
        libelle: this.form.get('libelle')?.value,
        reseau: undefined,
        rejet: undefined,
        dateDerniereModification: undefined,
      })
      .subscribe((typeReseau) => {
        this.modification = 'Modification effectuée avec succès';
        this.goTypeReseau();
        console.log('modif' + this.modification);
      });
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
        this.router.navigateByUrl('/typereseau/add');
      });
    console.log(this.ajouteSuccess);
  }

  goTypeReseau() {
    //renvoie au meme page
    this.router.navigateByUrl('/typereseau/add');
  }
  //effacer le saisir dans l'input
  effacer() {
    this.gomme = '';
    this.goTypeReseau();
  }
  nouveau() {
    this.typeReseau2 = new TypeReseau();
  }
}
