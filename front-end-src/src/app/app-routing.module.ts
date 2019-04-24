import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { NotFoundComponent } from './not-found/not-found.component';
import { AuthGuard } from './services/guard/auth.guard';
import { CanActivate } from '@angular/router/src/utils/preactivation';

const routes: Routes = [
  { path: '', redirectTo: '/solicitante', pathMatch: 'full' },
  { path: 'login', loadChildren: './login/login.module#LoginModule' },
  { path: 'solicitante', loadChildren: './solicitante/solicitante.module#SolicitanteModule' },
  {
    path: 'root',
    loadChildren: './root/root.module#RootModule',
    canActivate: [AuthGuard]
  },
  {
    path: 'almoxarife',
    loadChildren: './almoxarife/almoxarife.module#AlmoxarifeModule',
    canActivate: [AuthGuard]
  },
  {
    path: 'administracao',
    loadChildren: './administracao/administracao.module#AdministracaoModule',
    canActivate: [AuthGuard]
  },
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
