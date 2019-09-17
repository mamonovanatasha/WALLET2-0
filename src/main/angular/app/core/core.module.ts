import {LOCALE_ID, NgModule, Optional, SkipSelf} from '@angular/core';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import localeRu from "@angular/common/locales/ru";
import {registerLocaleData} from "@angular/common";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {BrowserModule} from "@angular/platform-browser";
import {ConfigurationInterceptor} from "@app/core/service";

registerLocaleData(localeRu);

@NgModule({
    imports: [
        BrowserAnimationsModule,
        BrowserModule,
        FormsModule,
        ReactiveFormsModule,
        HttpClientModule,
    ],
    declarations: [

    ],
    providers: [
        ConfigurationInterceptor,
        {provide: LOCALE_ID, useValue: 'ru'},
        // {provide: RouteReuseStrategy, useClass: CustomRouteReuseStrategy},
        {provide: HTTP_INTERCEPTORS, useClass: ConfigurationInterceptor, multi: true},
        // {provide: HTTP_INTERCEPTORS, useClass: CustomHttpInterceptor, multi: true},
        // {provide: HTTP_INTERCEPTORS, useClass: BlobErrorHttpInterceptor, multi: true},
        // {provide: HTTP_INTERCEPTORS, useClass: UnauthorizedInterceptor, multi: true},
    ],
})
export class CoreModule {
    constructor(@Optional() @SkipSelf() parentModule: CoreModule) {
        if (parentModule) {
            throw new Error('CoreModule is already loaded. Import only in AppModule');
        }
    }
}
