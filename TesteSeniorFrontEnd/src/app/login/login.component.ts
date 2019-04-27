import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UsuarioService } from '../services/usuario.service';
import { SessionService } from '../services/session.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  formLogin: FormGroup;
  errMessage: string;

  constructor(
    private router: Router,
    private fb: FormBuilder,
    private ss: SessionService,
    private us: UsuarioService
  ) { }

  ngOnInit() {
    this.formLogin = this.fb.group({
      inputEmail: ['', [Validators.required]],
      inputPassword: ['', Validators.required]
    });
  }

  logar() {
    if (this.formLogin.valid) {
      const login = this.formLogin.get("inputEmail").value;
      const senha = this.formLogin.get("inputPassword").value;
      this.us.logar(login, senha).subscribe(res => {
        this.ss.logar(res);
        this.redirect();
      }, e => this.errMessage = e.error.message);
    }
  }

  private redirect(): void {
    if (this.ss.isPerfilAdministrativo()) {
      this.router.navigate(['/administracao']);
    } else if (this.ss.isPerfilAlmoxarife()){
      this.router.navigate(['/almoxarife']);
    }
  }

  abrirSolicitacao = ()  => this.router.navigate(['/solicitante'])
}
