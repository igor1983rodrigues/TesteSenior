import { Injectable } from '@angular/core';

import { Solicitacao } from 'src/entities/solicitacao.entity';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BaseService } from './base.service';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: "root"
})
export class SolicitacaoService extends BaseService {
    private dadosEstaticos: Solicitacao[] = [{
        idSolicitacao: 1,
        solicitanteSolicitacao: "Alguém de Algum Lugar",
        descricaoItemSolicitacao: "Pilhas AAA",
        emailSolicitacao: "alguem@algullugar.com.gn",
        valorSolicitacao: 250
    },
    {
        idSolicitacao: 2,
        solicitanteSolicitacao: "Namorado da Fátima Bernardes",
        descricaoItemSolicitacao: "Lacrador automatizado",
        emailSolicitacao: "dep.tuliogadelha@camara.leg.br",
        valorSolicitacao: 24171
    }];

    constructor(private httpClient: HttpClient) {
        super();
        this.relativePath = '/solicitacao';
    }

    get(id: number): Solicitacao {
        return this.dadosEstaticos.find(item => item.idSolicitacao == id);
    }

    salvar(model: Solicitacao): Observable<any> {
        return this.httpClient.post(this.getUrl(), model);
    }

    listSolicitacao(): Solicitacao[] {
        return this.dadosEstaticos;
    }
}