import { Component, OnInit } from '@angular/core';
import {User} from "../data-types/User";

@Component({
  selector: 'app-template-form',
  templateUrl: './template-form.component.html',
  styleUrls: ['./template-form.component.css']
})
export class TemplateFormComponent implements OnInit {
  user : User = {email:'testEmail', name:'testName'}
  constructor() { }

  ngOnInit(): void {
  }
  onSubmit(form: any){
    console.log(form)
  }
}
