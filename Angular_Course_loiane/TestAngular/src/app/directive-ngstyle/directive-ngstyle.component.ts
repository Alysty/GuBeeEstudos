import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-directive-ngstyle',
  templateUrl: './directive-ngstyle.component.html',
  styleUrls: ['./directive-ngstyle.component.css']
})
export class DirectiveNgstyleComponent implements OnInit {

  active: boolean = false;
  fontSize: number = 10;
  constructor() { }

  ngOnInit(): void {
  }

  activate(){
    this.active = !this.active;
  }
}
