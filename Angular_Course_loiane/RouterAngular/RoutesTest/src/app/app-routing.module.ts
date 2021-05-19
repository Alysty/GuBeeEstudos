import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {LoginComponent} from "./login/login.component";

import {NotFoundComponent} from "./courses/not-found/not-found.component";
import {AuthGuard} from "./guards/auth.guard";

const routes: Routes = [
  {path: '', component: HomeComponent, canActivate: [AuthGuard]},
  {path: 'courses', canActivate: [AuthGuard], loadChildren: () => import('./courses/courses.module').then(m => m.CoursesModule)},
  {path: 'students', canActivate: [AuthGuard], loadChildren: () => import('./students/students.module').then(m => m.StudentsModule)},
  {path: 'login', component: LoginComponent},
  {path: 'notFound', component:NotFoundComponent , canActivate: [AuthGuard]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
