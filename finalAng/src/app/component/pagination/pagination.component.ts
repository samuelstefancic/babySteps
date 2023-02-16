import { Router } from '@angular/router';
import { TypeReseau } from 'src/app/model/type-reseau';
import { TypeReseauService } from './../../services/type-reseau.service';
import { Component } from '@angular/core';

@Component({
  selector: 'app-pagination',
  templateUrl: './pagination.component.html',
  styleUrls: ['./pagination.component.css'],
})
export class PaginationComponent {
  pages: number[] = [1, 2, 3, 4];
  pageNumber = this.pages[0];
  typereseaux: TypeReseau[] = [];
  selectedDeviceObj = 10;
  constructor(
    private typeReseauSer: TypeReseauService,
    private router: Router
  ) {}
  firstPage() {
    this.pageNumber = this.pages[0];
    this.router.navigateByUrl(
      `/typereseau/page/${this.pageNumber}/${this.selectedDeviceObj}`
    );
  }

  nextPage() {
    this.pageNumber++;
    this.router.navigateByUrl(
      `/typereseau/page/${this.pageNumber}/${this.selectedDeviceObj}`
    );
  }
  page5() {
    console.log(this.pageNumber);
  }
  lastPage() {
    this.pageNumber = this.pages[3];
    this.router.navigateByUrl(
      `/typereseau/page/${this.pageNumber}/${this.selectedDeviceObj}`
    );
  }

  previousPage() {
    this.pageNumber--;
    this.router.navigateByUrl(
      `/typereseau/page/${this.pageNumber}/${this.selectedDeviceObj}`
    );
  }
}
