import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SecondTestService {

  constructor() { }

  getTestArray(){
    return ["First", "Second", "Third"]
  }
}
