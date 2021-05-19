import { Component, OnInit } from '@angular/core';
import {LoginAuthService} from "./login-auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string = '';
  password: string = '';

  constructor(private loginAuthService: LoginAuthService,
              private router:Router) { }

  ngOnInit(): void {
  }

  login(){
    let auth = this.loginAuthService.checkIfAuth(this.username, this.password);
    if(auth){

      this.router.navigate(['/']).catch();
    }else{

    }
  }
}
