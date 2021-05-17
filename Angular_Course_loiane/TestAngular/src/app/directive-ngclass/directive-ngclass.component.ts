import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-directive-ngclass',
  templateUrl: './directive-ngclass.component.html',
  styleUrls: ['./directive-ngclass.component.css']
})
export class DirectiveNgclassComponent implements OnInit {

  test: boolean = true;

  constructor() { }

  ngOnInit(): void {
  }


  changeTest(){
    this.test = !this.test;
  }
}
