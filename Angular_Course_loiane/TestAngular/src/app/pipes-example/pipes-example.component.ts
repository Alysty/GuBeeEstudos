import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pipes-example',
  templateUrl: './pipes-example.component.html',
  styleUrls: ['./pipes-example.component.css']
})
export class PipesExampleComponent implements OnInit {

  book: any = {
    title: 'Learning angular',
    rating: 4.54321 ,
    numberOfPages: 314 ,
    price: 20.00 ,
    releaseDate: new Date(2020, 5, 23),
    url: 'testurl.com'
  }
  constructor() { }

  ngOnInit(): void {
  }

}
