import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Reseau } from '../model/reseau';
import { JsonConvertService } from './json-convert.service';

@Injectable({
  providedIn: 'root',
})
export class ReseauService {
  private url: string = 'http://localhost:8080/final/api/reseau';
  checkLogin: any;
  constructor(
    private httpClient: HttpClient,
    private convert: JsonConvertService
  ) {}

  public getAll(): Observable<Reseau[]> {
    return this.httpClient.get<Reseau[]>(this.url);
  }
  public getById(idTypeReseau: number): Observable<Reseau> {
    return this.httpClient.get<Reseau>(`${this.url}/${idTypeReseau}`);
  }
  public delete(idTypeReseau: number): Observable<void> {
    return this.httpClient.delete<void>(`${this.url}/${idTypeReseau}`);
  }
  public update(reseau: Reseau): Observable<Reseau> {
    return this.httpClient.put<Reseau>(
      `${this.url}/${reseau.idReseau}`,
      this.convert.reseauTOJson(reseau)
    );
  }
  public create(reseau: Reseau): Observable<Reseau> {
    return this.httpClient.post<Reseau>(
      this.url,
      this.convert.reseauTOJson(reseau)
    );
  }
  public getAllInPage(
    pageNumber: number,
    itemPerPage: number
  ): Observable<Reseau[]> {
    return this.httpClient.get<Reseau[]>(
      `${this.url}/page/${pageNumber}/${itemPerPage}`
    );
  }

  // public getNextPage(pageNumber: number): Observable<TypeReseau[]> {
  //   return this.httpClient.get<TypeReseau[]>(
  //     `${this.url}/page/next/${pageNumber}`
  //   );
  // }
  public getFirstPage(pageNumber: number): Observable<Reseau[]> {
    return this.httpClient.get<Reseau[]>(
      `${this.url}/page/first/${pageNumber}`
    );
  }
  public getLastPage(itemNumber: number): Observable<Reseau[]> {
    return this.httpClient.get<Reseau[]>(`${this.url}/page/last/${itemNumber}`);
  }
  public getAllInLibelle(
    libelle: string,
    pageNumber: number,
    itemPerPage: number
  ): Observable<Reseau[]> {
    return this.httpClient.get<Reseau[]>(
      `${this.url}/page/${libelle}/${pageNumber}/${itemPerPage}`
    );
  }
}
