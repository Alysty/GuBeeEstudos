import { Injectable } from '@angular/core';
import {LogService} from "../shared/log.service";

@Injectable({
  providedIn: 'root'
})
export class CursosService {
  courses : string [] = ['first', 'second', 'third'];
  constructor(private logService: LogService) { }
  getCourses(){
    this.logService.consoleLog('Acquiring courses list')
    return this.courses
  }
  addValue(valueToAdd : string){
    this.logService.consoleLog(`Adding course ${valueToAdd} to courses list`)
    this.courses.push(valueToAdd)
  }
}
