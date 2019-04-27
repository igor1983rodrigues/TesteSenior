import { NgModule } from '@angular/core';
import { CommonModule, registerLocaleData } from '@angular/common';
import localePt from '@angular/common/locales/pt';

import { AdministracaoRoutingModule } from './administracao-routing.module';
import { ViewsModule } from '../shared/views/views.module';

registerLocaleData(localePt, 'pt');

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    ViewsModule,
    AdministracaoRoutingModule
  ],
  exports: []
})
export class AdministracaoModule { }
