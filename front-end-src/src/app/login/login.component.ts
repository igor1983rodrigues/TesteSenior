import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UsuarioService } from '../services/usuario.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  formLogin: FormGroup;

  constructor(
    private router: Router,
    private fb: FormBuilder,
    private us: UsuarioService
  ) { }

  ngOnInit() {
    this.formLogin = this.fb.group({
      inputEmail: ['', [Validators.required, Validators.email]],
      inputPassword: ['', Validators.required]
    });
  }

  logar() {
    const login = this.formLogin.get("inputEmail").value;
    const senha = this.formLogin.get("inputPassword").value;
    this.us.logar(login, senha).subscribe(res => {
      alert('Sucesso');
      this.router.navigate(['/']);
    }, error => {
      console.error(error);
      alert('falha');
    });
  }

}
