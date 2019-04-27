import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { Solicitacao } from 'src/entities/solicitacao.entity';
import { SolicitacaoService } from 'src/app/services/solicitacao.service';
import { SessionService } from 'src/app/services/session.service';
import { Usuario } from 'src/entities/usuario.entity';
import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal';
import { SimpleModalComponent } from '../../modal/simple-modal/simple-modal.component';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styleUrls: ['./formulario.component.css']
})
export class FormularioComponent implements OnInit {
  bsModalRef: BsModalRef;
  modalFeedback: number;
  modalFeedbackMessage: string;

  formSolicitante: FormGroup;
  solicitacao: Solicitacao = null;
  constructor(
    private solicitacaoService: SolicitacaoService,
    private formBuilder: FormBuilder,
    private activatedRoute: ActivatedRoute,
    private ss:SessionService,
    private modalService: BsModalService,
    private router: Router
  ) { }

  private preencherForm(s: Solicitacao): Solicitacao {
    this.formSolicitante.get("nomeSolicitante").setValue(s.solicitanteSolicitacao);
    this.formSolicitante.get("emailSolicitante").setValue(s.emailSolicitacao);
    this.formSolicitante.get("descItem").setValue(s.descricaoItemSolicitacao);
    this.formSolicitante.get("precoProduto").setValue(s.valorSolicitacao);

    return s;
  }

  private carregarInformacoes() {
    this.activatedRoute.params.subscribe((res: { id: number }) => {
      if (!!res.id) {
        this.solicitacaoService.get(res.id).subscribe(s => this.solicitacao = this.preencherForm(s));
      } else {
        this.solicitacao = this.preencherForm({
          descricaoItemSolicitacao: null,
          emailSolicitacao: this.getUsuario().emailUsuario,
          solicitanteSolicitacao: this.getUsuario().nomeUsuario,
          valorSolicitacao: 0
        });
      }
    }, error => this.abrirModal('Feerback', error.message));
  }

  private buildForm() {
    this.formSolicitante = this.formBuilder.group({
      nomeSolicitante: [null, [Validators.required, Validators.maxLength(64)]],
      emailSolicitante: [null, [Validators.required, Validators.email]],
      descItem: [null, [Validators.required, Validators.maxLength(256)]],
      precoProduto: [0, [Validators.required, Validators.min(3), Validators.max(999999999.99)]]
    });
  }

  ngOnInit() {
    this.modalFeedback = 0;
    this.buildForm()
    this.carregarInformacoes();
  }

  enviarSolicitacao(): boolean {
    if (this.formSolicitante.valid) {
      this.solicitacao.solicitanteSolicitacao = this.formSolicitante.get("nomeSolicitante").value;
      this.solicitacao.emailSolicitacao = this.formSolicitante.get("emailSolicitante").value;;
      this.solicitacao.descricaoItemSolicitacao = this.formSolicitante.get("descItem").value;
      this.solicitacao.valorSolicitacao = this.formSolicitante.get("precoProduto").value;

      this.solicitacaoService.salvar(this.solicitacao).subscribe(res => this.sucesso(res), err => this.error(err));
    } else {
      return false;
    }
  }

  private sucesso({ id, message }) {
    this.modalFeedback = id;
    this.modalFeedbackMessage = message;
    this.formSolicitante.reset();
  }

  private error({ error }) {
    this.modalFeedback = -1;
    this.modalFeedbackMessage = error.message;
  }

  fecharFeedBack(): void {
    this.modalFeedback = 0;
    this.modalFeedbackMessage = "";
  }

  aprovar() : void {
    debugger;
    this.solicitacao.dtAprovadoSolicitacao = new Date();
    this.solicitacaoService.atualizar(this.solicitacao).subscribe(res => {
      this.voltar();
    }, (error) => this.abrirModal('Feerback', error.message));
  }

  isLogado = ():boolean => this.ss.isLogado()

  getUsuario = ():Usuario => this.ss.getUsuario() || new Usuario();

  reprovar(): void {
    this.solicitacao.dtReprovadoSolicitacao = new Date();
    this.solicitacaoService.atualizar(this.solicitacao).subscribe(res => {
      this.voltar();
    }, (error) => this.abrirModal('Feerback', error.message));
  }

  voltar = () => {
    let arr: string[] = this.router.url.split("/");
    arr.pop();
    arr.pop();
    this.router.navigate(arr);
  }

  abrirModal(title: string, ...mensagem: string[]) {
    const initialState = {
      list: mensagem,
      title: title
    };
    this.bsModalRef = this.modalService.show(SimpleModalComponent, {initialState});
    this.bsModalRef.content.closeBtnName = 'Fechar';
    }
}
