import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {LoginAuthService} from "./login-auth.service";
import {LoginComponent} from "./login.component";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {FormsModule} from "@angular/forms";



@NgModule({
  declarations: [
    LoginComponent
  ],
  imports: [
    NgbModule,
    FormsModule
  ],
  providers: [LoginAuthService],
  exports:[]

})
export class LoginModule { }
