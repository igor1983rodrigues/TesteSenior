import { Component, OnInit } from '@angular/core';

import { Solicitacao } from 'src/entities/solicitacao.entity';
import { SolicitacaoService } from 'src/app/services/solicitacao.service';

@Component({
  selector: 'app-lista',
  templateUrl: './lista.component.html',
  styleUrls: ['./lista.component.css']
})
export class ListaComponent implements OnInit {
  solicitacaoList: Solicitacao[];

  constructor(private solicitacaoService: SolicitacaoService) { }

  ngOnInit() {
    this.solicitacaoService
      .listSolicitacao()
      .subscribe(lista => this.solicitacaoList = lista, error => alert(error.message));
  }

}
