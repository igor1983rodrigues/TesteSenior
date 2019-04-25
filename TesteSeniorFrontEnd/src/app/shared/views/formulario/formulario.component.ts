import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { Solicitacao } from 'src/entities/solicitacao.entity';
import { SolicitacaoService } from 'src/app/services/solicitacao.service';
import { applySourceSpanToStatementIfNeeded } from '@angular/compiler/src/output/output_ast';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styleUrls: ['./formulario.component.css']
})
export class FormularioComponent implements OnInit {
  modalFeedback: number;
  modalFeedbackMessage: string;

  formSolicitante: FormGroup;
  solicitacao: Solicitacao = null;
  constructor(
    private solicitacaoService: SolicitacaoService,
    private formBuilder: FormBuilder,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) { }

  private buildForm() {
    this.activatedRoute.params.subscribe((res: { id: number }) => {
      if (!!res.id) {
        this.solicitacao = this.solicitacaoService.get(res.id);
      } else {
        this.solicitacao = new Solicitacao();
      }

      this.formSolicitante = this.formBuilder.group({
        nomeSolicitante: [this.solicitacao.solicitanteSolicitacao, [Validators.required, Validators.maxLength(64)]],
        emailSolicitante: [this.solicitacao.emailSolicitacao, [Validators.required, Validators.email]],
        descItem: [this.solicitacao.descricaoItemSolicitacao, [Validators.required, Validators.maxLength(256)]],
        precoProduto: [this.solicitacao.valorSolicitacao, [Validators.required, Validators.min(3), Validators.max(999999999.99)]]
      });
    });
  }

  ngOnInit() {
    this.modalFeedback = 0;
    this.buildForm();
  }

  enviarSolicitacao(): boolean {
    if (this.formSolicitante.valid) {
      this.solicitacao.solicitanteSolicitacao = this.formSolicitante.get("nomeSolicitante").value;
      this.solicitacao.emailSolicitacao=this.formSolicitante.get("emailSolicitante").value;;
      this.solicitacao.descricaoItemSolicitacao=this.formSolicitante.get("descItem").value;
      this.solicitacao.valorSolicitacao=this.formSolicitante.get("precoProduto").value;

      this.solicitacaoService.salvar(this.solicitacao).subscribe(res => this.sucesso(res), err => this.error(err));
    } else {
      return false;
    }
  }

  private sucesso({id, message}) {
    this.modalFeedback = id;
    this.modalFeedbackMessage = message;
    this.formSolicitante.reset();
  }

  private error({error}){
    this.modalFeedback = -1;
    this.modalFeedbackMessage = error.message;
  }
  
  fecharFeedBack(): void {
    this.modalFeedback = 0;
    this.modalFeedbackMessage = "";
  }

  reprovar(): void {
    alert("reprovado");
  }

}
