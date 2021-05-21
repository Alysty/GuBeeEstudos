import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-data-form',
  templateUrl: './data-form.component.html',
  styleUrls: ['./data-form.component.css']
})
export class DataFormComponent implements OnInit {

  // @ts-ignore
  form: FormGroup;
  constructor(private formBuilder:FormBuilder) { }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      email: [null, [Validators.email, Validators.required]],
      name: [null, [Validators.required, Validators.minLength(3)]]

    });
  }

  onSubmit (){
    console.log(this.form)
  }
}
