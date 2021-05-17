import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-custom-directives',
  templateUrl: './custom-directives.component.html',
  styleUrls: ['./custom-directives.component.css']
})
export class CustomDirectivesComponent implements OnInit {

  flag : boolean = true;
  constructor() { }

  ngOnInit(): void {
  }

  changeFlag(){
    this.flag = !this.flag;
  }
}
