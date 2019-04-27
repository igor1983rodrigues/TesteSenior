import { Injectable } from '@angular/core';

import { Solicitacao } from 'src/entities/solicitacao.entity';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BaseService } from './base.service';
import { Observable } from 'rxjs';
import { SessionService } from './session.service';

@Injectable({
    providedIn: "root"
})
export class SolicitacaoService extends BaseService {

    constructor(
        private ss: SessionService,
        private httpClient: HttpClient
    ) {
        super();
        this.relativePath = '/solicitacao';
    }

    get = (id: number): Observable<Solicitacao> => this.httpClient.get<Solicitacao>(`${this.getUrl()}/${id}`)

    salvar(model: Solicitacao): Observable<any> {
        return this.httpClient.post(this.getUrl(), model);
    }

    atualizar(model: Solicitacao) {
        const url = `${this.getUrl()}/${model.idSolicitacao || 0}`;
        return this.httpClient.put(url, model);
    }

    listSolicitacao(): Observable<Solicitacao[]> {
        let url = this.getUrl();

        if (this.ss.isPerfilAlmoxarife()) {
            url += '/emaberto';
        }

        return this.httpClient.get<Solicitacao[]>(url);
    }

    filtrar(filtro: any): Observable<Solicitacao[]> {
        const f: string[] = ['filtro:' + JSON.stringify(filtro)];
        return this.httpClient.get<Solicitacao[]>(`${this.getUrl()}/filtro`, {params: filtro});
    }
}