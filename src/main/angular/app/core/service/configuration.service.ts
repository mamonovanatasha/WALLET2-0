import {Inject, Injectable} from '@angular/core';
import {DOCUMENT} from '@angular/common';
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from "@angular/common/http";
import {Observable} from "rxjs/Rx";
import {environment} from '@env/environment';
import {fakeBackend} from "@app/core/dev";

@Injectable()
export class ConfigurationInterceptor implements HttpInterceptor {
    server: string;

    constructor(@Inject(DOCUMENT) document:any) {
        this.server = document.baseURI;
        console.log("Server url config: " + this.server);
        console.log("Fake backend is " + environment.fakeBackend);
    }

    intercept(req:HttpRequest<any>, next:HttpHandler):Observable<HttpEvent<any>> {
        let url: string = req.url;
        let method: string = req.method;

        if (this.server != null) {
            req = req.clone({
                url: this.server + req.url
            });
        }

        if (environment.fakeBackend) {
            return fakeBackend(url, method, req)
        }

        return next.handle(req);
    }
}
