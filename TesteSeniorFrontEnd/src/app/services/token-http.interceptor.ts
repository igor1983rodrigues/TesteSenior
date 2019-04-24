import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable()
export class TokenHttpInterceptor implements HttpInterceptor {

    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

        // console.log(req.withCredentials, req.url, req.headers);
        // const newReq = req.clone({
        //     headers: req.headers.set("Content-Type", "application/x-www-form-urlencoded")
        //         .set('Access-Control-Allow-Origin', '*')
        //         .set('Access-Control-Allow-Methods', 'GET, POST, OPTIONS, PUT, PATCH, DELETE')
        //         .set('Access-Control-Allow-Headers', 'X-Requested-With,content-type')
        //         .set('Access-Control-Allow-Credentials', 'true')
        // });
        // return next.handle(newReq);
        return next.handle(req);
    }
}