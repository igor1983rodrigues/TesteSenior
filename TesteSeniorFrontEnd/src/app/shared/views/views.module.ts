import { NgModule, LOCALE_ID } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { NgxCurrencyModule } from 'ngx-currency';
import { ModalModule } from 'ngx-bootstrap/modal';

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
        ModalModule,
        AMModalModule,
        NgxCurrencyModule.forRoot(CURRENCY_MASK_CONFIG_PTBR),
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

