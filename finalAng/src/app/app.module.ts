import { AuthenticationInterceptor } from './interceptors/authentication.interceptor';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { AllTypeReseauComponent } from './component/typeReseau/all-type-reseau/all-type-reseau.component';
import { TypeReseauComponent } from './component/typeReseau/type-reseau/type-reseau.component';

import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { routes } from './routes';
import { AccueilComponent } from './component/accueil/accueil.component';

import { PaginationComponent } from './component/pagination/pagination.component';
import { ModifierTypereseauComponent } from './component/modifier-typereseau/modifier-typereseau.component';
import { CreationTypereseauComponent } from './component/creation-typereseau/creation-typereseau.component';
import { ConsultationTypereseauComponent } from './component/consultation-typereseau/consultation-typereseau.component';

@NgModule({
  declarations: [
    AppComponent,
    AllTypeReseauComponent,
    TypeReseauComponent,
    AccueilComponent,
    PaginationComponent,
    ModifierTypereseauComponent,
    CreationTypereseauComponent,
    ConsultationTypereseauComponent,
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
  ],

  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthenticationInterceptor,
      multi: true,
    },
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
