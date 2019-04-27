import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthGuard } from '../services/guard/auth.guard';
import { ListaComponent } from '../shared/views/lista/lista.component';

const administracaoRoutes: Routes = [{
    path: '',
    component: ListaComponent,
    canActivate: [AuthGuard],
    children: []
}];

@NgModule({
    imports: [RouterModule.forChild(administracaoRoutes)],
    exports: [RouterModule]
})
export class AdministracaoRoutingModule { }