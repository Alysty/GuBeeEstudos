import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {CoursesComponent} from "./courses.component";
import {CourseDetailComponent} from "./course-detail/course-detail.component";
import {CoursesService} from "./courses.service";
import {RouterModule} from "@angular/router";
import {CoursesRoutingModule} from "./courses-routing.module";




@NgModule({
  declarations:
    [
      CoursesComponent,
      CourseDetailComponent
    ],
  imports: [
    CommonModule,
    RouterModule,
    CoursesRoutingModule
  ],
  exports:[],
  providers:[CoursesService]
})
export class CoursesModule { }
