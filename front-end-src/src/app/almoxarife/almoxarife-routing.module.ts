import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AlmoxarifeComponent } from './almoxarife.component';
import { SolicitanteComponent } from '../solicitante/solicitante.component';
import { AuthGuard } from '../services/guard/auth.guard';

const almoxarifeRoutes: Routes = [{
    path: '',
    component: AlmoxarifeComponent,
    canActivate: [AuthGuard],
    children: []
},{
    path: 'solicitacao/:id',
    component: SolicitanteComponent,
    canActivate:[AuthGuard],
    children:[]
}];

@NgModule({
    imports: [RouterModule.forChild(almoxarifeRoutes)],
    exports: [RouterModule]
})
export class AlmoxarifeRoutingModule { }