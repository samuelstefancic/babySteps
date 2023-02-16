import { FormControl, FormGroup, Validators } from '@angular/forms';
import { TypeReseauService } from './../../services/type-reseau.service';
import { Component, OnInit } from '@angular/core';
import { TypeReseau } from 'src/app/model/type-reseau';
import { Router, ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { TypereseauValidator } from '../validator/typereseau-validator';

@Component({
  selector: 'app-modifier-typereseau',
  templateUrl: './modifier-typereseau.component.html',
  styleUrls: ['./modifier-typereseau.component.css'],
})
export class ModifierTypereseauComponent implements OnInit {
  form!: FormGroup;
  typeReseau2: TypeReseau = new TypeReseau();
  obsTypeReseaux!: Observable<TypeReseau[]>;
  modification = '';
  success = false;
  edit = false;

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
    this.success = false;
    this.edit = false;
    this.activatedRoute.queryParams.subscribe((queryParams) => {
      console.log(queryParams);
      if (queryParams['creation']) {
        this.success = true;
      }
      if (queryParams['edit']) {
        this.edit = true;
      }
    });
  }

  save() {
    if (confirm('Etes-vous sûr ?') == true) {
      if (this.typeReseau2.idTypeReseau) {
        this.update();
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
        this.router.navigateByUrl('/typereseau/modification?edit=ok');
      });
  }

  goTypeReseau() {
    //renvoie au meme page
    this.router.navigateByUrl('/typereseau');
  }
}
