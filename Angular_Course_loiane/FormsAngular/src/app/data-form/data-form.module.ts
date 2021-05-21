import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DataFormComponent } from './data-form.component';
import {DataFormRoutingModule} from "./data-form-routing.module";
import {ReactiveFormsModule} from "@angular/forms";
import {TemplateFormModule} from "../template-form/template-form.module";



@NgModule({
  declarations: [
    DataFormComponent
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    DataFormRoutingModule,
    TemplateFormModule
  ]
})
export class DataFormModule { }
