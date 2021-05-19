import {EventEmitter, Injectable } from '@angular/core';
import {User} from "./types/User";

@Injectable({
  providedIn: 'root'
})
export class LoginAuthService {

  users : User[] = [
    {username:'alyssa', password: '1234'},
    {username:'peter', password: '1234'},
    {username:'rowan', password: '1234'}
  ]
  showMenu = new EventEmitter<boolean>();
  constructor() { }

  checkIfAuth(username: string, password:string){
    for(let user of this.users){
      if (user.username == username && user.password == password){
        this.showMenu.emit(true);
        return true;
      }
    }
    this.showMenu.emit(false);
    return false;
  }
}
