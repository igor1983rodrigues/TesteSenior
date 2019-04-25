import { NgModule } from '@angular/core';

import { ContainerCommonComponent } from './container-common/container-common.component';
import { AlertComponent } from './alert.component';
import { CommonModule } from '@angular/common';

@NgModule({
    imports: [CommonModule],
    exports: [ContainerCommonComponent, AlertComponent],
    declarations: [ContainerCommonComponent, AlertComponent],
    providers: [],
})
export class ContainerModule { }
