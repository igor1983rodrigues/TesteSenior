import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, MaxLengthValidator, FormGroup, FormControl } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { Solicitacao } from 'src/entities/solicitacao.entity';
import { SolicitacaoService } from '../services/solicitacao.service';

@Component({
  selector: 'app-solicitante',
  templateUrl: './solicitante.component.html',
  styleUrls: ['./solicitante.component.css']
})
export class SolicitanteComponent implements OnInit {
  formSolicitante: FormGroup;
  solicitacao: Solicitacao;
  constructor(
    private solicitacaoService: SolicitacaoService,
    private formBuilder: FormBuilder,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) { }

  private buildForm() {
    this.formSolicitante = this.formBuilder.group({
      nomeSolicitante: [null, [Validators.required, Validators.maxLength(64)]],
      emailSolicitante: [null, [Validators.required, Validators.email]],
      descItem: [null, [Validators.required, Validators.maxLength(256)]],
      precoProduto: [null, [Validators.required, Validators.min(3), Validators.max(999999999.99)]]
    });

    this.activatedRoute.params.subscribe((res: { id: number }) => {
      this.solicitacao = this.solicitacaoService.get(res.id);
      this.formSolicitante.get("nomeSolicitante").setValue(this.solicitacao.nomeSolicitante);
      this.formSolicitante.get("emailSolicitante").setValue(this.solicitacao.emailSolicitante);
      this.formSolicitante.get("descItem").setValue(this.solicitacao.descricaoItem);
      this.formSolicitante.get("precoProduto").setValue(this.solicitacao.valorSolicitado);
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
