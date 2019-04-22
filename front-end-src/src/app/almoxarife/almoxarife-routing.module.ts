import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AlmoxarifeComponent } from './almoxarife.component';
import { SolicitanteComponent } from '../solicitante/solicitante.component';

const almoxarifeRoutes: Routes = [{
    path: '',
    component: AlmoxarifeComponent,
    canActivate: [],
    children: []
},{
    path: 'solicitacao/:id',
    component: SolicitanteComponent,
    canActivate:[],
    children:[]
}];

@NgModule({
    imports: [RouterModule.forChild(almoxarifeRoutes)],
    exports: [RouterModule]
})
export class AlmoxarifeRoutingModule { }