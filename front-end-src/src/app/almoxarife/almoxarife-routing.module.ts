import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AuthGuard } from '../services/guard/auth.guard';
import { ListaComponent } from '../shared/views/lista/lista.component';
import { FormularioComponent } from '../shared/views/formulario/formulario.component';

const almoxarifeRoutes: Routes = [{
    path: '',
    component: ListaComponent,
    canActivate: [AuthGuard],
    children: []
},{
    path: 'solicitacao/:id',
    component: FormularioComponent,
    canActivate:[AuthGuard],
    children:[]
}];

@NgModule({
    imports: [RouterModule.forChild(almoxarifeRoutes)],
    exports: [RouterModule]
})
export class AlmoxarifeRoutingModule { }