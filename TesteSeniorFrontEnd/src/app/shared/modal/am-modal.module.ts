import { ModalModule } from 'ngx-bootstrap/modal';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SimpleModalComponent } from './simple-modal/simple-modal.component';
import { AMModalService } from './am-modal.service';

@NgModule({
    imports: [
      CommonModule,
      ModalModule.forRoot()
    ],
    exports: [],
    declarations: [SimpleModalComponent],
    entryComponents: [SimpleModalComponent],
    providers: [AMModalService],
})
export class AMModalModule { }
