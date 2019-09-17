import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {plainToClass} from "class-transformer";
import {UserRow} from "@main/model/userRow";

@Injectable()
export class UserService {

    constructor(private http: HttpClient) {
    }


    getUsers(): Observable<UserRow[]> {

        let urlMainPart = "api/users";
        console.log("URL: " + urlMainPart);

        return this.http.get<UserRow[]>(urlMainPart)
            .map(response => plainToClass(UserRow, response as Object[]));
    }



     deleteUser(userId : number): Observable<boolean>{
         let urlMainPart = "api/delete-user/" + userId;
         console.log("URL: " + urlMainPart);

         return this.http.post<boolean>(urlMainPart, {});
     }

}
