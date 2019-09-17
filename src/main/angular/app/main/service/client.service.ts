import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {plainToClass} from "class-transformer";
import {ClientRow} from "@main/model/clientRow";

@Injectable()
export class ClientService {

    constructor(private http: HttpClient) {
    }


    getClients(): Observable<ClientRow[]> {

        let urlMainPart = "api/clients";
        console.log("URL: " + urlMainPart);

        return this.http.get<ClientRow[]>(urlMainPart)
            .map(response => plainToClass(ClientRow, response as Object[]));
    }


}
