import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AccountService {
  constructor(private httpClient: HttpClient) {}

  authentification(login: string, password: string): Observable<any> {
    let headers = new HttpHeaders({
      Authorization: 'Basic ' + window.btoa(login + ':' + password),
    });
    return this.httpClient.get<any>('http://localhost:8080/final/api/auth', {
      headers: headers,
    });
  }

  public isAuthenticated(): boolean {
    return localStorage.getItem('tokenId') != null ? true : false;
  }

  public checkLoginExist(login: string): Observable<boolean> {
    if (login) {
      return this.httpClient.get<boolean>(
        `http://localhost:8080/final/api/account/checklogin/${login}`
      );
    }
    return new Observable((observer) => {
      observer.next(false);
    });
  }

  public logout() {
    localStorage.clear();
  }
}
