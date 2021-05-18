import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CoursesService {

  getCourses(){
    return [
      {id:1, name: 'Angular'},
      {id:2, name: 'java'},
      {id:3, name: 'c#'},
      {id:4, name: 'c++'}
    ]
  }
  getCourse(id: number){
    let courses = this.getCourses();
    for (let course of courses){
      if(course.id == id){
        return course
      }
    }
    return null;
  }
  constructor() { }
}
