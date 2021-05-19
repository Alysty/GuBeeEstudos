import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { HomeComponent } from './home/home.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NotFoundComponent } from './courses/not-found/not-found.component';
import { FormsModule } from "@angular/forms";
import { LoginModule } from "./login/login.module";
import {LoginAuthService} from "./login/login-auth.service";
import {AuthGuard} from "./guards/auth.guard";
import {CourseGuard} from "./guards/course.guard";
import {StudentGuard} from "./guards/student.guard";

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NotFoundComponent
  ],
  imports: [
    BrowserModule,
    NgbModule,
    LoginModule,
    AppRoutingModule,
    FormsModule

  ],
  providers: [LoginAuthService, AuthGuard, CourseGuard, StudentGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
