import { SessionService } from './session.service';
import {
  HttpInterceptor,
  HttpRequest,
  HttpHandler,
  HttpEvent
} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable()
export class TokenHttpInterceptor implements HttpInterceptor {
  constructor(private ss: SessionService) {}

  intercept(
    req: HttpRequest<any>,
    next: HttpHandler
  ): Observable<HttpEvent<any>> {
    if (this.ss.isLogado()) {
      console.log(req.withCredentials, req.url, req.headers);
      const newReq = req.clone({
        headers: req.headers.set(
          'Authorization',
          `Bearer ${this.ss.getToken()}`
        )
      });
      return next.handle(newReq);
    } else {
      return next.handle(req);
    }
  }
}
