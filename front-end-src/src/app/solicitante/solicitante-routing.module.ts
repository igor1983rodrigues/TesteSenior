import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FormularioComponent } from '../shared/views/formulario/formulario.component';

const solicitanteRoutes: Routes = [{
    path: '',
    component: FormularioComponent
}];

@NgModule({
    imports: [RouterModule.forChild(solicitanteRoutes)],
    exports: [RouterModule]
})
export class SolicitanteRoutingModule { }