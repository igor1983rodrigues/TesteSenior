import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { Solicitacao } from 'src/entities/solicitacao.entity';
import { SolicitacaoService } from 'src/app/services/solicitacao.service';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styleUrls: ['./formulario.component.css']
})
export class FormularioComponent implements OnInit {
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
    this.buildForm();
  }

  enviarSolicitacao(): boolean {
    if (this.formSolicitante.valid) {
      alert('teste');
    } else {
      return false;
    }
  }

  reprovar(): void {
    alert("reprovado");
  }

}
