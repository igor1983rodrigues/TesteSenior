import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { LoginComponent } from './login.component';
import { LoginRoutingModule } from './login-routing.module';
import { UsuarioService } from '../services/usuario.service';
import { BaseService } from '../services/base.service';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { TokenHttpInterceptor } from '../services/token-http.interceptor';
import { ContainerModule } from '../shared/container/container.module';
import { SessionService } from '../services/session.service';

@NgModule({
  declarations: [LoginComponent],
  providers: [
    BaseService,
     UsuarioService,
     SessionService,
     {
       provide: HTTP_INTERCEPTORS,
       useClass: TokenHttpInterceptor,
       multi: true
     }
    ],
  imports: [
    CommonModule,
    FormsModule,
    ContainerModule,
    ReactiveFormsModule,
    LoginRoutingModule
  ],
  exports: [LoginComponent]
})
export class LoginModule {}
