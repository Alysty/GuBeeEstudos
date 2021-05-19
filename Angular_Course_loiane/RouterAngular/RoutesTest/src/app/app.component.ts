import {Component, OnDestroy, OnInit} from '@angular/core';
import {LoginAuthService} from "./login/login-auth.service";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit, OnDestroy{
  title = 'RoutesTest';
  showMenu: boolean = false;
  // @ts-ignore
  subscription: Subscription;

  constructor(private loginAuthService: LoginAuthService) {
  }

  ngOnInit(){
    this.subscription = this.loginAuthService.showMenu.subscribe(
      (params)=>{this.showMenu = params})

  }

  ngOnDestroy() {
    this.subscription.unsubscribe()
  }
}
