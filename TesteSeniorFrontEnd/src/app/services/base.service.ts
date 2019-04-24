import { isDevMode } from '@angular/core';

export class BaseService {

    protected relativePath: string;

    constructor() { }
    
    protected getUrl = ():string => `${this.getBasePath()}${this.relativePath||'/'}`;
    
    protected getBasePath(): string {
        if (isDevMode()) {
            return 'http://localhost:8080/TesteSeniorBackend/api';
        } else {
            return '/api';
        }
    }

}