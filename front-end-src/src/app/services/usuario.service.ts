import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BaseService } from './base.service';
import { Observable } from 'rxjs';

@Injectable({providedIn: 'root'})
export class UsuarioService extends BaseService {

    constructor(private httpClient: HttpClient) {
        super();
        this.relativePath = '/usuario';
    }

    logar(login: string, senha: string): Observable<any> {
        return this.httpClient.post(`${this.getUrl()}/login`, {
            login: login,
            senha: senha
        });
    }
}