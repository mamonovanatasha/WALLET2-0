import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {BrowserModule} from "@angular/platform-browser";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {NgModule} from "@angular/core";
import {HttpClientModule} from "@angular/common/http";
import {ClarityModule, ClrFormsNextModule} from "@clr/angular";
import {AppComponent} from './app.component';
import {ROUTING} from "./app.routing";
import {registerLocaleData} from '@angular/common';
import localeRu from '@angular/common/locales/ru';
import {MainComponent} from "@main/main.component";
import {CoreModule} from "@app/core";
import {StompRService} from "@stomp/ng2-stompjs";
import {ClientService} from "@main/service/client.service";
import {UserService} from "@main/service/user.service";
import {UserComponent} from "@main/user/user.component";

registerLocaleData(localeRu);

@NgModule({
    declarations: [
        AppComponent,
        MainComponent,
        UserComponent,

    ],
    imports: [
        BrowserAnimationsModule,
        BrowserModule,
        FormsModule,
        ReactiveFormsModule,
        HttpClientModule,
        ClrFormsNextModule,
        ClarityModule,
        CoreModule,
        ROUTING
    ],
    providers: [
        ClientService,

        StompRService,
        UserService,


        // CookieService,
        // {provide: LOCALE_ID, useValue: 'ru'},
        // {provide: HTTP_INTERCEPTORS, useClass: ConfigurationInterceptor, multi: true},
        // {provide: HTTP_INTERCEPTORS, useClass: CustomHttpInterceptor, multi: true},
        // {provide: HTTP_INTERCEPTORS, useClass: BlobErrorHttpInterceptor, multi: true},
        // {provide: HTTP_INTERCEPTORS, useClass: UnauthorizedInterceptor, multi: true},
    ],
    bootstrap: [AppComponent]
})
export class AppModule {
}
