import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { HomeComponent } from './home/home.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NotFoundComponent } from './courses/not-found/not-found.component';
import { CoursesModule } from "./courses/courses.module";
import { StudentsModule } from "./students/students.module";
import { FormsModule } from "@angular/forms";
import { LoginModule } from "./login/login.module";

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NotFoundComponent
  ],
  imports: [
    BrowserModule,
    NgbModule,
    CoursesModule,
    StudentsModule,
    LoginModule,
    AppRoutingModule,
    FormsModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
