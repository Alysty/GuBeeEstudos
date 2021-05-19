import {EventEmitter, Injectable } from '@angular/core';
import {User} from "./types/User";
import {Router} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class LoginAuthService {

  users : User[] = [
    {username:'alyssa', password: '1234'},
    {username:'peter', password: '1234'},
    {username:'rowan', password: '1234'}
  ]
  isAuth: boolean = false;
  showMenu = new EventEmitter<boolean>();
  constructor(private router:Router) { }

  checkIfAuth(username: string, password:string){
    for(let user of this.users){
      if (user.username == username && user.password == password){

        this.showMenu.emit(true);
        this.isAuth =  true;
        this.router.navigate(['/']).catch();
      }
    }
    if(!this.isAuth){
      this.showMenu.emit(false);
      this.isAuth  = false;
    }
  }
  userIsAuthenticated(){
    return this.isAuth;
  }
}
