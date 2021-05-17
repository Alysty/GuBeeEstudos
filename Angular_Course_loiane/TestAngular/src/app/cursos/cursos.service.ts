import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CursosService {
  courses : string [] = ['first', 'second', 'third'];
  constructor() { }
  getCourses(){
    return this.courses
  }
  addValue(valueToAdd : string){
    this.courses.push(valueToAdd)
  }
}
