import { Injectable } from '@angular/core';

import { Solicitacao } from 'src/entities/solicitacao.entity';

@Injectable({
    providedIn: "root"
})
export class SolicitacaoService {
    private dadosEstaticos: Solicitacao[] = [        {
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
        }    ];

    constructor() { }
    
    get(id: number): Solicitacao {
      return this.dadosEstaticos.find(item => item.idSolicitacao == id);
    }

    listSolicitacao(): Solicitacao[] {
        return this.dadosEstaticos;
    }
}