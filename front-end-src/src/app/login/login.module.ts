import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { LoginComponent } from './login.component';
import { LoginRoutingModule } from './login-routing.module';
import { UsuarioService } from '../services/usuario.service';
import { BaseService } from '../services/base.service';

@NgModule({
  declarations: [LoginComponent],
  providers: [BaseService, UsuarioService],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    LoginRoutingModule
  ],
  exports: [LoginComponent]
})
export class LoginModule {}
