import { Injectable } from '@angular/core';

import { Solicitacao } from 'src/entities/solicitacao.entity';

@Injectable({
    providedIn: "root"
})
export class SolicitacaoService {
    private dadosEstaticos: Solicitacao[] = [        {
            idSolicitacao: 1,
            nomeSolicitante: "Alguém de Algum Lugar",
            descricaoItem: "Pilhas AAA",
            emailSolicitante: "alguem@algullugar.com.gn",
            valorSolicitado: 250
        },
        {
            idSolicitacao: 2,
            nomeSolicitante: "Namorado da Fátima Bernardes",
            descricaoItem: "Lacrador automatizado",
            emailSolicitante: "dep.tuliogadelha@camara.leg.br",
            valorSolicitado: 24171
        }    ];

    constructor() { }
    
    get(id: number): Solicitacao {
      return this.dadosEstaticos.find(item => item.idSolicitacao == id);
    }

    listSolicitacao(): Solicitacao[] {
        return this.dadosEstaticos;
    }
}