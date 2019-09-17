import {Component, OnDestroy, OnInit} from '@angular/core';
import "rxjs/add/operator/finally";
import "rxjs/add/operator/map";
import "rxjs/add/operator/distinctUntilChanged";
import "rxjs/add/operator/debounceTime";
import "rxjs/add/operator/mergeMap";
import "rxjs/add/operator/takeUntil";
import "rxjs/add/observable/of";
import {finalize, tap} from "rxjs/operators";
import {ClientRow} from "@main/model/clientRow";
import {ClientService} from "@main/service/client.service";


@Component({
    selector: 'app-main',
    templateUrl: './main.component.html',
    styleUrls: ['./main.component.scss']
})
export class MainComponent implements OnInit, OnDestroy {

    isLoading: boolean = false;

    filteredRecords: ClientRow[] = [];
    selectedRecord: ClientRow = new ClientRow();
    selectedRows: ClientRow[] = [];

    initRows: boolean = false;

    constructor(private clientService: ClientService
                ) {
    }

    ngOnInit() {

        this.updateTable();
    }

    ngOnDestroy() {
    }

    updateTable() {
        this.clientService.getClients()
            .pipe(
                tap(() => {
                    // do something before all actions
                }),
                finalize(() => {
                    // do something after all actions
                })
            ).subscribe(
            response => {
                console.log("updateTable subscribe", response);
                this.filteredRecords = response;
            },
            (error) => {
                console.log("updateTable error", error);
            });

    }

}