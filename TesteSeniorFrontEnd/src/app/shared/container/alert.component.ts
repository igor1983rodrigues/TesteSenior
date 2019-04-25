import { Component, OnInit, Input } from '@angular/core';

@Component({
    selector: 'app-alert-component',
    templateUrl: './alert.component.html'
})
export class AlertComponent implements OnInit {

    @Input() tipo: AlertType;

    constructor() {
        this.tipo =  AlertType.DANGER;
     }

    ngOnInit() { }

    classes() {
        return { 'alert-success': this.tipo == AlertType.SUCCESS, 'alert-danger': this.tipo == AlertType.SUCCESS, 'alert-warning': this.tipo == AlertType.WARNING };
    }
}

enum AlertType {
    SUCCESS,
    DANGER,
    WARNING
}
