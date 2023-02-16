import { JsonConvertService } from './json-convert.service';
import { HttpClient } from '@angular/common/http';
import { Injectable, Type } from '@angular/core';
import { Observable } from 'rxjs';
import { TypeReseau } from '../model/type-reseau';

@Injectable({
  providedIn: 'root',
})
export class TypeReseauService {
  private url: string = 'http://localhost:8080/final/api/typereseau';

  constructor(
    private httpClient: HttpClient,
    private convert: JsonConvertService
  ) {}

  public getAll(): Observable<TypeReseau[]> {
    return this.httpClient.get<TypeReseau[]>(this.url);
  }
  public getById(idTypeReseau: number): Observable<TypeReseau> {
    return this.httpClient.get<TypeReseau>(`${this.url}/${idTypeReseau}`);
  }
  public delete(idTypeReseau: number): Observable<void> {
    return this.httpClient.delete<void>(`${this.url}/${idTypeReseau}`);
  }
  public update(typeReseau: TypeReseau): Observable<TypeReseau> {
    return this.httpClient.put<TypeReseau>(
      `${this.url}/${typeReseau.idTypeReseau}`,
      this.convert.typeReseauToJson(typeReseau)
    );
  }
  public create(typeReseau: TypeReseau): Observable<TypeReseau> {
    return this.httpClient.post<TypeReseau>(
      this.url,
      this.convert.typeReseauToJson(typeReseau)
    );
  }
  public getAllInPage(
    pageNumber: number,
    itemPerPage: number
  ): Observable<TypeReseau[]> {
    return this.httpClient.get<TypeReseau[]>(
      `${this.url}/page/${pageNumber}/${itemPerPage}`
    );
  }

  // public getNextPage(pageNumber: number): Observable<TypeReseau[]> {
  //   return this.httpClient.get<TypeReseau[]>(
  //     `${this.url}/page/next/${pageNumber}`
  //   );
  // }
  public getFirstPage(itemPerPage: number): Observable<TypeReseau[]> {
    return this.httpClient.get<TypeReseau[]>(
      `${this.url}/page/first/${itemPerPage}`
    );
  }
  public getLastPage(itemNumber: number): Observable<TypeReseau[]> {
    return this.httpClient.get<TypeReseau[]>(
      `${this.url}/page/last/${itemNumber}`
    );
  }
  public getPreviousPage(pageNumber: number) {
    return this.httpClient.get<TypeReseau[]>(
      `${this.url}/page/previous/${pageNumber}`
    );
  }
  public getNextPage(pageNumber: number) {
    return this.httpClient.get<TypeReseau[]>(
      `${this.url}/page/next/${pageNumber}`
    );
  }
  public getAllInLibelle(
    libelle: string,
    pageNumber: number,
    itemPerPage: number
  ): Observable<TypeReseau[]> {
    return this.httpClient.get<TypeReseau[]>(
      `${this.url}/page/${libelle}/${pageNumber}/${itemPerPage}`
    );
  }
  public checkIdExist(idTypereseau: number): Observable<boolean> {
    if (idTypereseau) {
      return this.httpClient.get<boolean>(`${this.url}/exist/${idTypereseau}`);
    }
    return new Observable((observer) => {
      observer.next(false);
    });
  }
}
