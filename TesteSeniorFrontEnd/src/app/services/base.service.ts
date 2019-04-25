import { isDevMode } from '@angular/core';

export class BaseService {

    protected relativePath: string;

    constructor() { }

    protected getUrl = (): string => `${this.getBasePath()}${this.relativePath || '/'}`;

    protected getBasePath(): string {
        if (isDevMode()) {
            console.log("isDevMode");
            return 'http://localhost:8080/api';
        } else {
            return '/api';
        }
    }

}