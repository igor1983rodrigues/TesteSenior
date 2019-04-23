import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdministracaoComponent } from './administracao.component';
import { AuthGuard } from '../services/guard/auth.guard';

const administracaoRoutes: Routes = [{
    path: '',
    component: AdministracaoComponent,
    canActivate: [AuthGuard],
    children: []
}];

@NgModule({
    imports: [RouterModule.forChild(administracaoRoutes)],
    exports: [RouterModule]
})
export class AdministracaoRoutingModule { }