import { PaginationComponent } from './component/pagination/pagination.component';
import { ModifierTypereseauComponent } from './component/modifier-typereseau/modifier-typereseau.component';

import { ConsultationTypereseauComponent } from './component/consultation-typereseau/consultation-typereseau.component';

import { CreationTypereseauComponent } from './component/creation-typereseau/creation-typereseau.component';

import { AllTypeReseauComponent } from './component/typeReseau/all-type-reseau/all-type-reseau.component';
import { Routes } from '@angular/router';
import { AccueilComponent } from './component/accueil/accueil.component';

export const routes: Routes = [
  { path: 'accueil', component: AccueilComponent },
  { path: 'typereseau/add', component: CreationTypereseauComponent },
  { path: 'typereseau', component: AllTypeReseauComponent },
  { path: 'typereseau/creation', component: CreationTypereseauComponent },
  {
    path: 'typereseau/edit/:idTypeReseau',
    component: ModifierTypereseauComponent,
  },
  {
    path: 'typereseau/consultation',
    component: ConsultationTypereseauComponent,
  },
  {
    path: 'typereseau/modification',
    component: ModifierTypereseauComponent,
  },
  {
    path: 'typereseau/page/next/:pageNumber',
    component: AllTypeReseauComponent,
  },
  {
    path: 'typereseau/page/first/:selectedDeviceObj"',
    component: AllTypeReseauComponent,
  },
  { path: 'typereseau/page/last"', component: AllTypeReseauComponent },
  {
    path: 'typereseau/consulation/:idTypeReseauconsu',
    component: AllTypeReseauComponent,
  },
  {
    path: 'typereseau/page/previous/:pageNumber',
    component: AllTypeReseauComponent,
  },
  {
    path: 'typereseau/page/next/:pageNumber',
    component: AllTypeReseauComponent,
  },
  { path: '', redirectTo: 'accueil', pathMatch: 'full' },
  { path: 'typereseau/:idTypeReseau', component: AllTypeReseauComponent },
  {
    path: 'typereseau/libelle/:libelle',
    component: AllTypeReseauComponent,
  },
  {
    path: 'typereseau/edit/:idTypeReseau',
    component: ModifierTypereseauComponent,
  },
  {
    path: 'typereseau/page/:pageNumber/:selectedDeviceObj',
    component: AllTypeReseauComponent,
  },
];
