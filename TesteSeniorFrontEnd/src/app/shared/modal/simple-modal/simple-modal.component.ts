import { Component, OnInit } from '@angular/core';
import { BsModalRef } from 'ngx-bootstrap/modal';

@Component({
    selector: 'app-simple-modal',
    templateUrl: './simple-modal.component.html'
})

export class SimpleModalComponent implements OnInit {
    
    title: string;
    closeBtnName: string;
    list: any[] = [];

    constructor(public bsModalRef: BsModalRef) {}

    ngOnInit() { 
        this.list.push('PROFIT!!!');
    }
}