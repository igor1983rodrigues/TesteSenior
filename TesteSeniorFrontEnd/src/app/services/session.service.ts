import { Injectable } from '@angular/core';
import { Perfil } from 'src/entities/perfil.entity';
import { Usuario } from 'src/entities/usuario.entity';

@Injectable({ providedIn: "root" })
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

    isLogado = (): boolean => localStorage.length > 0 && !!this.getToken();

    getToken = (): string => localStorage.getItem('token');

    getUsuario = (): Usuario => {
        if (!!localStorage['usuario']) {
            return JSON.parse(localStorage.getItem('usuario')) as Usuario
        } else {
            return null;
        }
    }

    getPerfil = (): Perfil => {
        if (!!localStorage['perfil']) {
            return JSON.parse(localStorage.getItem('perfil')) as Perfil
        } else {
            return null;
        }
    };

    logar = (stream: { token: string, perfil: Perfil, usuario: any }) => {
        delete stream.usuario.senhaUsuario;
        delete stream.usuario.perfil;
        localStorage['token'] = stream.token;
        localStorage['perfil'] = JSON.stringify(stream.perfil);
        localStorage['usuario'] = JSON.stringify(stream.usuario);
    }

    deslogar = () => localStorage.clear()
}