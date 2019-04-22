import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RootComponent } from './root.component';

const rootRoutes: Routes = [{
    path: '',
    component: RootComponent,
    canActivate: [],
    children: []
}];

@NgModule({
    imports: [RouterModule.forChild(rootRoutes)],
    exports: [RouterModule]
})
export class RootRoutingModule { }