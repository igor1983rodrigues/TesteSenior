export class Solicitacao {
    idSolicitacao?: number;
    solicitanteSolicitacao: string;
    descricaoItemSolicitacao: string;
    valorSolicitacao: number;
    emailSolicitacao: string;
    dtAprovadoSolicitacao?: Date;
    dtReprovadoSolicitacao?: Date;
    motivoReprovacaoSolicitacao?: string;
}