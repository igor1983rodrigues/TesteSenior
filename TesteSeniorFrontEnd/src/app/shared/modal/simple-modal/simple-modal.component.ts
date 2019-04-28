import { Component, OnInit } from '@angular/core';
import { BsModalRef } from 'ngx-bootstrap/modal';

export enum TipoAMModal {
  PRIMARY,
  SECONDARY,
  INFO,
  SUCCESS,
  WARNING,
  DANGER,
  DARK,
  LIGHT
}

@Component({
  selector: 'app-simple-modal',
  templateUrl: './simple-modal.component.html'
})
export class SimpleModalComponent implements OnInit {
  title: string;
  closeBtnName: string;
  list: any[] = [];
  tipoAMModal: TipoAMModal = TipoAMModal.PRIMARY;

  constructor(public bsModalRef: BsModalRef) {}

  ngOnInit() {}

  getHeaderClass = () => ({
    'bg-primary': this.tipoAMModal === TipoAMModal.PRIMARY,
    'bg-secondary': this.tipoAMModal === TipoAMModal.SECONDARY,
    'bg-success': this.tipoAMModal === TipoAMModal.SUCCESS,
    'bg-danger': this.tipoAMModal === TipoAMModal.DANGER,
    'bg-warning text-dark': this.tipoAMModal === TipoAMModal.WARNING,
    'bg-info': this.tipoAMModal === TipoAMModal.INFO,
    'bg-light text-dark': this.tipoAMModal === TipoAMModal.LIGHT,
    'bg-dark': this.tipoAMModal === TipoAMModal.DARK,
    'text-white': [
      TipoAMModal.PRIMARY,
      TipoAMModal.DANGER,
      TipoAMModal.DARK,
      TipoAMModal.INFO,
      TipoAMModal.SECONDARY,
      TipoAMModal.SUCCESS
    ].includes(this.tipoAMModal),
    'text-dark': [TipoAMModal.WARNING, TipoAMModal.LIGHT].includes(
      this.tipoAMModal
    )
  })

  getIconClass = () => ({
    'fa-check-circle': this.tipoAMModal === TipoAMModal.SUCCESS,
    'fa-exclamation-circle': this.tipoAMModal === TipoAMModal.DANGER,
    'fa-exclamation-triangle': this.tipoAMModal === TipoAMModal.WARNING,
    'fa-info-circle': this.tipoAMModal === TipoAMModal.INFO
  })
}
