import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DataFormComponent } from './data-form.component';
import {DataFormRoutingModule} from "./data-form-routing.module";



@NgModule({
  declarations: [
    DataFormComponent
  ],
  imports: [
    CommonModule,
    DataFormRoutingModule
  ]
})
export class DataFormModule { }
