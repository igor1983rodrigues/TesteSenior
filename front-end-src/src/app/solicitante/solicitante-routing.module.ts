import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { SolicitanteComponent } from './solicitante.component';

const solicitanteRoutes: Routes = [{
    path: '',
    component: SolicitanteComponent
}];

@NgModule({
    imports: [RouterModule.forChild(solicitanteRoutes)],
    exports: [RouterModule]
})
export class SolicitanteRoutingModule { }