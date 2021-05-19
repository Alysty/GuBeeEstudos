import { NgModule } from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {StudentsComponent} from "./students.component";
import {StudentDetailComponent} from "./student-detail/student-detail.component";
import {StudentFormComponent} from "./student-form/student-form.component";
import {AuthGuard} from "../guards/auth.guard";


const routes: Routes = [
  {path: 'students', component: StudentsComponent, canActivate: [AuthGuard], children:[
      {path: 'new', component: StudentFormComponent},
      {path: ':id', component: StudentDetailComponent},
      {path: ':id/edit', component: StudentFormComponent}
    ]
  }

]

@NgModule({
  imports: [
    RouterModule.forChild(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class StudentsRoutingModule { }
