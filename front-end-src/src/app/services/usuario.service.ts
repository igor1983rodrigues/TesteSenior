import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BaseService } from './base.service';
import { Observable } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class UsuarioService extends BaseService {

    constructor(private httpClient: HttpClient) {
        super();
        this.relativePath = '/usuario';
    }

    logar(login: string, senha: string): Observable<any> {
        const body = {
            login: login,
            senha: senha
        };
        const header = new HttpHeaders();
        header.append('Content-Type', 'application/x-www-form-urlencoded');
        
        return this.httpClient.post(`${this.getUrl()}/login`, body);
    }
}