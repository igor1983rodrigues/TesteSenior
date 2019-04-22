import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { NotFoundComponent } from './not-found/not-found.component';

const routes: Routes = [
  { path: '', redirectTo: '/solicitante', pathMatch: 'full' },
  { path: 'login', loadChildren: './login/login.module#LoginModule' },
  { path: 'solicitante', loadChildren: './solicitante/solicitante.module#SolicitanteModule' },
  { path: 'root', loadChildren: './root/root.module#RootModule' },
  { path: 'almoxarife', loadChildren: './almoxarife/almoxarife.module#AlmoxarifeModule' },
  { path: 'administracao', loadChildren: './administracao/administracao.module#AdministracaoModule' },
  { path: '**', component: NotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
  /**
   *
   */
  constructor() {
    console.log('AppRoutingModule:constructor');
  }
}
