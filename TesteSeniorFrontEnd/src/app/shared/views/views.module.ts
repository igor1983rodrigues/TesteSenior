import { NgModule, LOCALE_ID } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { NgxCurrencyModule } from 'ngx-currency';
import { TooltipModule } from 'ngx-bootstrap/tooltip';
import { PaginationModule } from 'ngx-bootstrap/pagination';

import { SolicitacaoService } from 'src/app/services/solicitacao.service';
import { CURRENCY_MASK_CONFIG_PTBR } from '../currency-mask-config.const';
import { ContainerModule } from '../container/container.module';
import { ListaComponent } from './lista/lista.component';
import { FormularioComponent } from './formulario/formulario.component';
import { AMModalModule } from '../modal/am-modal.module';

@NgModule({
    declarations: [
        ListaComponent,
        FormularioComponent
    ],
    imports: [
        CommonModule,
        FormsModule,
        RouterModule,
        ReactiveFormsModule,
        AMModalModule,
        NgxCurrencyModule.forRoot(CURRENCY_MASK_CONFIG_PTBR),
        TooltipModule.forRoot(),
        PaginationModule.forRoot(),
        ContainerModule
    ],
    exports: [
        ListaComponent,
        FormularioComponent
    ],
    providers: [
        SolicitacaoService,
        {
            provide: LOCALE_ID,
            useValue: "pt-BR"
        }
    ],
})
export class ViewsModule { }

