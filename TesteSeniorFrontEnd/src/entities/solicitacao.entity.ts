export class Solicitacao {
    idSolicitacao?: number;
    nomeSolicitante: string;
    descricaoItem: string;
    valorSolicitado: number;
    emailSolicitante: string;
    aprovado?: Date;
    reprovado?: Date;
    motivoReprovacao?: string;
}