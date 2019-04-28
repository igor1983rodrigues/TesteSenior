import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { SessionService } from '../session.service';

@Injectable({ providedIn: 'root' })
export class AuthGuard implements CanActivate {
    constructor(
        private sessionService: SessionService,
        private router: Router
    ) { }

    canActivate(
        route: ActivatedRouteSnapshot,
        state: RouterStateSnapshot
    ): Observable<boolean> | boolean {
        const logado: boolean = this.sessionService.isLogado();
        if (state.url === '/login' && logado) {
            this.router.navigate(['/solicitante']);
        } else if (state.url === '/login' || logado) {
            return true;
        } else {
            this.router.navigate(['/login']);
        }
    }
}
