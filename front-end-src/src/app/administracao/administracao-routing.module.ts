import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdministracaoComponent } from './administracao.component';

const administracaoRoutes: Routes = [{
    path: '',
    component: AdministracaoComponent,
    canActivate: [],
    children: []
}];

@NgModule({
    imports: [RouterModule.forChild(administracaoRoutes)],
    exports: [RouterModule]
})
export class AdministracaoRoutingModule { }