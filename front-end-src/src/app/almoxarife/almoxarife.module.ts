import { NgModule, LOCALE_ID } from '@angular/core';
import { CommonModule, registerLocaleData } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgxCurrencyModule } from 'ngx-currency';
import localePt from '@angular/common/locales/pt';
import localePtExtra from '@angular/common/locales/extra/pt';

import { AlmoxarifeComponent } from './almoxarife.component';
import { AlmoxarifeRoutingModule } from './almoxarife-routing.module';
import { SolicitacaoService } from '../services/solicitacao.service';
import { SolicitanteComponent } from '../solicitante/solicitante.component';
import { CURRENCY_MASK_CONFIG_PTBR } from '../shared/currency-mask-config.const';
import { ContainerModule } from '../shared/container/container.module';

registerLocaleData(localePt, 'pt');

@NgModule({
  declarations: [
    AlmoxarifeComponent,
    SolicitanteComponent
  ],
  providers: [
    SolicitacaoService,
    {
      provide: LOCALE_ID,
      useValue: "pt-BR"
    }
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    NgxCurrencyModule.forRoot(CURRENCY_MASK_CONFIG_PTBR),
    ContainerModule,
    AlmoxarifeRoutingModule
  ],
  exports: [AlmoxarifeComponent]
})
export class AlmoxarifeModule { }
