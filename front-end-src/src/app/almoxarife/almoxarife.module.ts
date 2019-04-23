import { NgModule } from '@angular/core';
import { CommonModule, registerLocaleData } from '@angular/common';
import localePt from '@angular/common/locales/pt';

import { AlmoxarifeRoutingModule } from './almoxarife-routing.module';
import { ContainerModule } from '../shared/container/container.module';
import { ViewsModule } from '../shared/views/views.module';

registerLocaleData(localePt, 'pt');

@NgModule({
  declarations: [
  ],
  providers: [
  ],
  imports: [
    CommonModule,
    ContainerModule,
    ViewsModule,
    AlmoxarifeRoutingModule
  ],
  exports: []
})
export class AlmoxarifeModule { }
