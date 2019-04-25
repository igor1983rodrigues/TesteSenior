import { Component, OnInit } from '@angular/core';
import { SessionService } from './services/session.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  title = 'front-end-src';

  constructor(
    private router: Router,
    private ss: SessionService
  ) { }

  ngOnInit(): void {
  }

  isLogado = () => this.ss.isLogado()

  isAlmoxarife = () => this.ss.isPerfilAlmoxarife()

  isAdministracao = () => this.ss.isPerfilAdministrativo()

  logout() {
    this.ss.deslogar();
    this.router.navigate(["/"]);
  }
}
