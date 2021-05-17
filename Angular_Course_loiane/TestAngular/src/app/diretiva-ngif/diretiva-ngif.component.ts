import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-diretiva-ngif',
  templateUrl: './diretiva-ngif.component.html',
  styleUrls: ['./diretiva-ngif.component.css']
})
export class DiretivaNgifComponent implements OnInit {

  courses: string [] = [];

  changingVar: boolean = true;
  constructor() { }

  ngOnInit(): void {
  }

  changevar(){
    this.changingVar = ! this.changingVar;
  }
}
