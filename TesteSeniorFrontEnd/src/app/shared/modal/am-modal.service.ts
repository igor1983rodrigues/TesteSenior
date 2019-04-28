import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal';
import { Injectable } from '@angular/core';
import {
  SimpleModalComponent,
  TipoAMModal
} from './simple-modal/simple-modal.component';

@Injectable({
  providedIn: 'root'
})
export class AMModalService {
  constructor(private modalService: BsModalService) {}

  abrirModalDanger = (titulo: string, ...message: string[]) =>
    this.abrirModal(titulo, TipoAMModal.DANGER, message);

  abrirModalSuccess = (titulo: string, ...message: string[]) =>
    this.abrirModal(titulo, TipoAMModal.SUCCESS, message);

  abrirModalInfo = (titulo: string, ...message: string[]) =>
    this.abrirModal(titulo, TipoAMModal.INFO, message);

  private abrirModal(
    titulo: string,
    tipoAMModalp: TipoAMModal,
    message: string[]
  ) {
    const initialState = {
      tipoAMModal: tipoAMModalp,
      title: titulo,
      list: message
    };
    const bsModalRef: BsModalRef = this.modalService.show(
      SimpleModalComponent,
      { initialState }
    );
    bsModalRef.content.closeBtnName = 'Fechar';
  }
}
