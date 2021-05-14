import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-counter',
  templateUrl: './counter.component.html',
  styleUrls: ['./counter.component.css']
})
export class CounterComponent implements OnInit {

  public value: number = 0
  constructor() { }

  ngOnInit(): void {
  }

  increment(){
    this.value += 1
  }
  decrement(){
    this.value -= 1
  }
}
