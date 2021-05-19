import { Component, OnInit } from '@angular/core';
import {LoginAuthService} from "./login-auth.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string = '';
  password: string = '';

  constructor(private loginAuthService: LoginAuthService
              ) { }

  ngOnInit(): void {
  }

  login(){
    this.loginAuthService.checkIfAuth(this.username, this.password);
  }
}
