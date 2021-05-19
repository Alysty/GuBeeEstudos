import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class StudentsService {

  private students: any[] =  [
    {id:1, name: 'Peter', email: 'Peter@gmail.com'},
    {id:2, name: 'Alyssa' , email: 'Alyssa@gmail.com'},
    {id:3, name: 'Stephane' , email: 'Stephane@gmail.com'},
    {id:4, name: 'Rowan' , email: 'Rowan@gmail.com'}
  ]
  getStudents(){
    return this.students
  }
  getStudent(id: number){
    for (let student of this.getStudents()){
      if(student.id == id){
        return student
      }
    }
    return null;
  }
  addStudent(student: any){
    this.students.push(student);
  }

  constructor() { }
}
