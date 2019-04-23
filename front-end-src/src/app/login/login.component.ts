import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  formLogin: FormGroup;

  constructor(
    private router:Router,
    private fb: FormBuilder
    ) {}

  ngOnInit() {
    this.formLogin = this.fb.group({
      inputEmail: ['', Validators.required],
      inputPassword: ['', Validators.required]
    });
  }

  logar() {
    this.router.navigate(['/']);
  }

}
