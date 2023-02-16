import { TypereseauValidator } from './../../validator/typereseau-validator';
import { TypeReseauService } from './../../../services/type-reseau.service';
import { TypeReseau } from './../../../model/type-reseau';
import { Component, ElementRef, OnInit } from '@angular/core';

import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-all-type-reseau',
  templateUrl: './all-type-reseau.component.html',
  styleUrls: ['./all-type-reseau.component.css'],
})
export class AllTypeReseauComponent implements OnInit {
  type: TypeReseau = new TypeReseau();

  itemPerPage = [10, 15, 20];
  pageNumber = 0;

  selectedDeviceObj = this.itemPerPage[0];

  findByLibelle = '';

  typereseaux: TypeReseau[] = [];
  showMessage = false;
  constructor(
    private typeReseauSer: TypeReseauService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.initTypeReseau();
    this.activatedRoute.queryParams.subscribe((queryParams) => {
      console.log(queryParams);
    });

    this.activatedRoute.params.subscribe((params) => {
      if (params['libelle']) {
        this.typeReseauSer
          .getAllInLibelle(params['libelle'], this.pageNumber, 10)
          .subscribe((data: TypeReseau[]) => {
            this.typereseaux = data;
            this.showMessage = true;
            //  this.consultation();
          });
      }
      if (params['pageNumber']) {
        this.pageNumber = params['pageNumber'];
        this.initTypeReseau();
        console.log(this.pageNumber);
      }
      if (params['idTypeReseau']) {
        this.typeReseauSer
          .getById(params['idTypeReseau'])
          .subscribe((typereseau) => {
            this.type.idTypeReseau = typereseau.idTypeReseau;
          });
      }
    });
  }
  //select change
  onChangeObj(newObj: number) {
    this.selectedDeviceObj = newObj;
    this.initTypeReseau();
  }

  initTypeReseau() {
    if (this.type.idTypeReseau == null || undefined) {
      this.typeReseauSer
        .getAllInPage(this.pageNumber, this.selectedDeviceObj)
        .subscribe((data: TypeReseau[]) => {
          this.typereseaux = data;
        });
    }
  }

  delete() {
    this.typeReseauSer.delete(this.type.idTypeReseau!).subscribe(() => {
      this.router.navigateByUrl(`/typereseau`);
    });
  }
  modification() {
    this.router.navigateByUrl(`/typereseau/edit/${this.type.idTypeReseau}`);
  }
  ajouter() {
    this.router.navigateByUrl('/typereseau/add');
  }

  consultation() {
    this.typeReseauSer
      .getAllInLibelle(
        this.findByLibelle,
        this.pageNumber,
        this.selectedDeviceObj
      )
      .subscribe((data: TypeReseau[]) => {
        this.typereseaux = data;
      });
  }
}
