import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { NgxCurrencyModule } from 'ngx-currency';

import { SolicitanteRoutingModule } from './solicitante-routing.module';
import { CURRENCY_MASK_CONFIG_PTBR } from '../shared/currency-mask-config.const';
import { ContainerModule } from '../shared/container/container.module';
import { SolicitacaoService } from '../services/solicitacao.service';
import { ViewsModule } from '../shared/views/views.module';

@NgModule({
  declarations: [],
  providers: [SolicitacaoService],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    NgxCurrencyModule.forRoot(CURRENCY_MASK_CONFIG_PTBR),
    ContainerModule,
    ViewsModule,
    SolicitanteRoutingModule
  ],
  exports: []
})
export class SolicitanteModule { }
