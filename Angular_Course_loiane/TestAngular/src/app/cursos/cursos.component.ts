import { Component, OnInit } from '@angular/core';
import {CursosService} from "./cursos.service";

@Component({
  selector: 'app-cursos',
  templateUrl: './cursos.component.html',
  styleUrls: ['./cursos.component.css']
})
export class CursosComponent implements OnInit {

  courses: string [] = [];
  constructor(private cursoService: CursosService) {

  }

  ngOnInit(): void {
    this.courses = this.cursoService.getCourses();
  }
  addValue(valueToAdd : string){
    this.cursoService.addValue(valueToAdd)
  }
}
