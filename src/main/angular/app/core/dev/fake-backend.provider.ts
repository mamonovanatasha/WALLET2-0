import {HttpEvent, HttpRequest, HttpResponse} from "@angular/common/http";
import {Observable} from "rxjs/Observable";

import * as data from './jsonsFromBackEnd/clients.json';
import * as datausers from './jsonsFromBackEnd/users.json';

export function fakeBackend(url: string, method: string, request: HttpRequest<any>): Observable<HttpEvent<any>> {


    if (url.includes('api/clients') && method === "GET") {

        return new Observable(resp => {
            setTimeout(() => {
                resp.next(new HttpResponse({
                    status: 200,
                    body: data
                }));
                resp.complete();
            }, 500);
        });
    }
    if (url.includes('api/users') && method === "GET") {

        return new Observable(resp => {
            setTimeout(() => {
                resp.next(new HttpResponse({
                    status: 200,
                    body: datausers
                }));
                resp.complete();
            }, 500);
        });
    }

}
