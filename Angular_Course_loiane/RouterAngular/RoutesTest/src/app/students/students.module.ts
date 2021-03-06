import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { StudentsComponent } from './students.component';
import { StudentFormComponent } from './student-form/student-form.component';
import { StudentDetailComponent } from './student-detail/student-detail.component';
import {StudentsRoutingModule} from "./students-routing.module";
import {StudentsService} from "./students.service";
import {FormsModule} from "@angular/forms";
import {StudentsDeactivateGuard} from "../guards/students-deactivate.guard";



@NgModule({
  declarations: [
    StudentsComponent,
    StudentFormComponent,
    StudentDetailComponent
  ],
  imports: [
    CommonModule,
    StudentsRoutingModule,
    FormsModule
  ],
  exports:[],
  providers:[StudentsService, StudentsDeactivateGuard]
})
export class StudentsModule { }
