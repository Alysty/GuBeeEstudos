import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TemplateFormComponent } from './template-form.component';
import { TemplateFormRoutingModule } from "./template-form-routing.module";
import {FormsModule} from "@angular/forms";


@NgModule({
  declarations: [
    TemplateFormComponent
  ],
  imports: [
    CommonModule,
    TemplateFormRoutingModule,
    FormsModule
  ],
  providers:[],
  exports:[]
})
export class TemplateFormModule { }
