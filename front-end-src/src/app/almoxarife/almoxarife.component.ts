import { Component, OnInit } from '@angular/core';

import { SolicitacaoService } from '../services/solicitacao.service';
import { Solicitacao } from 'src/entities/solicitacao.entity';

@Component({
  selector: 'app-almoxarife',
  templateUrl: './almoxarife.component.html',
  styleUrls: ['./almoxarife.component.css']
})
export class AlmoxarifeComponent implements OnInit {
  solicitacaoList: Solicitacao[];

  constructor(private solicitacaoService: SolicitacaoService) { }

  ngOnInit() {
    this.solicitacaoList = this.solicitacaoService.listSolicitacao();
  }

}
