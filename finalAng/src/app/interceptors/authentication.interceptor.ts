import { AccountService } from './../services/account.service';
import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class AuthenticationInterceptor implements HttpInterceptor {
  constructor(private authSrv: AccountService) {}

  intercept(
    request: HttpRequest<unknown>,
    next: HttpHandler
  ): Observable<HttpEvent<unknown>> {
    if (this.authSrv.isAuthenticated()) {
      request = request.clone({
        headers: request.headers.append(
          'Authorization',
          localStorage.getItem('tokenId')!
        ),
      });
    }
    return next.handle(request);
  }
}
