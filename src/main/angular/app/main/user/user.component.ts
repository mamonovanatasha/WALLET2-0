import {Component, OnDestroy, OnInit} from '@angular/core';
import "rxjs/add/operator/finally";
import "rxjs/add/operator/map";
import "rxjs/add/operator/distinctUntilChanged";
import "rxjs/add/operator/debounceTime";
import "rxjs/add/operator/mergeMap";
import "rxjs/add/operator/takeUntil";
import "rxjs/add/observable/of";
import {finalize, tap} from "rxjs/operators";
import {UserRow} from "@main/model/userRow";
import {UserService} from "@main/service/user.service";
import {AbstractControl, FormBuilder, FormGroup} from "@angular/forms";
import {Dictionary} from "async";

export interface UserFields extends Dictionary<AbstractControl> {
    userNameControl: AbstractControl,
}
@Component({
    selector: 'user-table',
    templateUrl: './user.component.html',
    styleUrls: ['./user.component.scss']
})
export class UserComponent implements OnInit, OnDestroy {

    isLoading: boolean = false;

    filteredUsers: UserRow[] = [];
    selectedUser: UserRow = new UserRow();
    selectedUsers: UserRow[] = [];


    initUsers: boolean = false;


    doOpenUserModal: boolean = false;

    modalTitle: string;
    TITLE_ADD_NEW: string = "Add new Contribution";
    TITLE_EDIT: string = "Edit Contribution";

    fieldsFormGroup: FormGroup;
     userList: UserRow [] = [];



    constructor(private userHttpService: UserService,
                private builder: FormBuilder) {
    }
    ngOnInit() {

        this.updateTable();
    }

    ngOnDestroy() {
    }

    updateTable() {
        this.userHttpService.getUsers()
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
                this.filteredUsers = response;
            },
            (error) => {
                console.log("updateTable error", error);
            });

    }


    onAdd() {
        this.doOpenUserModal = true;
        this.modalTitle = this.TITLE_ADD_NEW;
    }

    onEdit() {
        this.doOpenUserModal = true;
        this.modalTitle = this.TITLE_EDIT;

        let selectedRow = this.selectedUsers[0];
        let user = this.userList.find(item => item.id === selectedRow.id);

        let inputs = this.fieldsFormGroup.controls as UserFields;
        inputs.nameControl.setValue(selectedRow.name);
        inputs.userNameControl.setValue(user);
    }
    closeModal() {
        this.doOpenUserModal = false;
        this.fieldsFormGroup.reset();
    }

    onDelete() {
        let selected: UserRow = this.selectedUsers[0];

        this.userHttpService.deleteUser(selected.id)
            .pipe(
                tap(() => {
                    // do something before all actions
                }),
                finalize(() => {
                    // do something after all actions
                })
            ).subscribe(
            response => {
                console.log("delete user sucsess subscribe", response);
                this.updateTable();
            },
            (error) => {
                console.log(" error delete user", error);
            });
    }
}