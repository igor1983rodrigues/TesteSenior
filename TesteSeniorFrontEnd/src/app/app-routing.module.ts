import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { NotFoundComponent } from './not-found/not-found.component';
import { AuthGuard } from './services/guard/auth.guard';
import { CanActivate } from '@angular/router/src/utils/preactivation';
import { AlmoxarifeGuard } from './services/guard/almoxarife.guard';
import { AdministrativoGuard } from './services/guard/administrativo.guard';

const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  {
    path: 'login',
    loadChildren: './login/login.module#LoginModule',
    canActivate: [AuthGuard]
  },
  {
    path: 'solicitante',
    loadChildren: './solicitante/solicitante.module#SolicitanteModule',
  },
  // {
  //   path: 'root',
  //   loadChildren: './root/root.module#RootModule',
  //   canActivate: [AuthGuard]
  // },
  {
    path: 'almoxarife',
    loadChildren: './almoxarife/almoxarife.module#AlmoxarifeModule',
    canActivate: [AuthGuard, AlmoxarifeGuard]
  },
  {
    path: 'administracao',
    loadChildren: './administracao/administracao.module#AdministracaoModule',
    canActivate: [AuthGuard, AdministrativoGuard]
  },
  { path: '**', component: NotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { useHash: true })],
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
