import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CursosService {

  constructor() { }
  getCourses(){
    return ['first', 'second', 'third']
  }
}
