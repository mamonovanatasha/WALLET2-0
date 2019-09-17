import {MainComponent} from "@main/main.component";
import {RouterModule, Routes} from "@angular/router";
import {ModuleWithProviders} from "@angular/core";
import {UserComponent} from "@main/user/user.component";


export const ROUTES: Routes = [
    {path: '', redirectTo: 'main', pathMatch: 'full'},
    {path: 'main', component: MainComponent},
    {path: 'users', component: UserComponent},

];

export const ROUTING: ModuleWithProviders = RouterModule.forRoot(ROUTES);
