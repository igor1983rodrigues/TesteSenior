import { Injectable } from '@angular/core';
import { Perfil } from 'src/entities/perfil.entity';

@Injectable({providedIn: "root"})
export class SessionService {
    
    constructor() { }
    
    isPerfilAlmoxarife() {
        return this.isPerfil("ALF");
    }

    isPerfilAdministrativo() {
        return this.isPerfil("ADM");
    }

    private isPerfil(siglaPerfil: string) {
        const perfil: Perfil = this.getPerfil() || new Perfil();

        return !!siglaPerfil
            && !!siglaPerfil
            && !!perfil.siglaPerfil
            && siglaPerfil.toLowerCase() == perfil.siglaPerfil.toLowerCase();
    }

    isLogado = (): boolean =>  localStorage.length > 0 && !!this.getToken();

    getToken = (): string =>  localStorage.getItem('token');

    getPerfil = (): Perfil => {
        if (!!localStorage['perfil']) {
            return JSON.parse(localStorage.getItem('perfil')) as Perfil
        } else {
            return null;
        }
    };

    logar = (stream: { token, perfil }) => {
        localStorage['token'] = stream.token;
        localStorage['perfil'] = JSON.stringify(stream.perfil);
    }

    deslogar = () => localStorage.clear()
}