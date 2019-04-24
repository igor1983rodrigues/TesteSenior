import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdministracaoComponent } from './administracao.component';
import { AdministracaoRoutingModule } from './administracao-routing.module';

@NgModule({
  declarations: [AdministracaoComponent],
  imports: [
    CommonModule,
    AdministracaoRoutingModule
  ],
  exports: [AdministracaoComponent]
})
export class AdministracaoModule { }
