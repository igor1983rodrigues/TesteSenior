import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, Router } from '@angular/router';
import { SessionService } from '../session.service';

@Injectable({providedIn: 'root'})
export class AdministrativoGuard implements CanActivate {
    constructor(
        private router: Router,
        private sessionService: SessionService
    ) { }

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        if (this.sessionService.isLogado() && this.sessionService.isPerfilAdministrativo) {
            return true;
        } else {
            this.router.navigate(['/login']);
        }
    }
}