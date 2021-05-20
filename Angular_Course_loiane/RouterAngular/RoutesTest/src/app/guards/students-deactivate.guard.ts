import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanDeactivate, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import {StudentFormComponent} from "../students/student-form/student-form.component";

@Injectable({
  providedIn: 'root'
})
export class StudentsDeactivateGuard implements CanDeactivate<StudentFormComponent> {
  canDeactivate(
    component: StudentFormComponent,
    currentRoute: ActivatedRouteSnapshot,
    currentState: RouterStateSnapshot,
    nextState?: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean  {
    console.log("aaaaaaaaaaaaaaaaaaaaaaaa")
    return true;
  }

}
