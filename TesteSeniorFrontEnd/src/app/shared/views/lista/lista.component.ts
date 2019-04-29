import { AMModalService } from './../../modal/am-modal.service';
import { Component, OnInit } from '@angular/core';

import { Solicitacao } from 'src/entities/solicitacao.entity';
import { SolicitacaoService } from 'src/app/services/solicitacao.service';
import { FormGroup } from '@angular/forms';
import { SessionService } from 'src/app/services/session.service';

@Component({
  selector: 'app-lista',
  templateUrl: './lista.component.html',
  styleUrls: ['./lista.component.css']
})
export class ListaComponent implements OnInit {
  solicitacaoList: Solicitacao[];
  formFiltro: FormGroup;
  filtroModel: {
    nomeSolicitante?: string,
    emailSolicitante?: string,
    descricao?: string,
    isPendente: boolean;
    isAprovado: boolean;
    isReprovado: boolean;
  };

  isAdministrador: boolean;
  isLoading: boolean;

  constructor(
    private solicitacaoService: SolicitacaoService,
    private modalService: AMModalService,
    private ss: SessionService
  ) {
    this.filtroModel = {
      isPendente: true,
      isAprovado: true,
      isReprovado: true
    };
    this.isLoading = true;
    this.isAdministrador = ss.isPerfilAdministrativo();
  }

  ngOnInit() {
    this.solicitacaoList = [];
    this.solicitacaoService
      .listSolicitacao()
      .subscribe(
        lista => (this.solicitacaoList = lista),
        error => this.openDialogError(error),
        () => (this.isLoading = false)
      );
  }

  getSituacao = (item: Solicitacao): number => {
    if (
      item.dtAprovadoSolicitacao == null &&
      item.dtReprovadoSolicitacao == null
    ) {
      return 0;
    } else if (item.dtAprovadoSolicitacao != null) {
      return 1;
    } else {
      return 2;
    }
  };

  getSituacaoClass = (item: Solicitacao): any => ({
    'badge-secondary': this.getSituacao(item) === 0,
    'badge-success': this.getSituacao(item) === 1,
    'badge-danger': this.getSituacao(item) === 2
  });

  getTotal = (): number => {
    let res = 0;
    this.solicitacaoList.forEach(item => res += item.valorSolicitacao);
    return res;
  }

  getSituacaoTexto = (item: Solicitacao): string => {
    switch (this.getSituacao(item)) {
      case 0:
        return 'PENDENTE';
      case 1:
        return 'APROVADO';
      case 2:
        return 'REPROVADO';
    }
  };

  filtrar(): void {
    this.isLoading = true;
    this.solicitacaoList = [];
    this.solicitacaoService
      .filtrar(this.filtroModel)
      .subscribe(
        res => (this.solicitacaoList = res),
        error => this.openDialogError(error),
        () => (this.isLoading = false)
      );
  }

  limparFiltro(): void {
    this.filtroModel = {
      isPendente: true,
      isAprovado: true,
      isReprovado: true
    };
    this.filtrar();
  }

  private openDialogError(error) {
    this.modalService.abrirModalDanger('Feedback', error.message);
    this.isLoading = false;
  }
}
