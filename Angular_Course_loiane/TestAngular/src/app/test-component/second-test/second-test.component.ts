
import { Component, OnInit } from '@angular/core';

import {SecondTestService} from "./second-test.service";


@Component({
  selector: 'app-second-test',
  templateUrl: './second-test.component.html',
  styleUrls: ['./second-test.component.css']
})
export class SecondTestComponent implements OnInit {

  public tests: String[];
  constructor(private secondTestService: SecondTestService) {
    this.tests = secondTestService.getTestArray();
  }


  ngOnInit(): void {
  }

}
