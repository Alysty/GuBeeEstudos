import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TemplateFormComponent } from './template-form.component';
import { TemplateFormRoutingModule } from "./template-form-routing.module";


@NgModule({
  declarations: [
    TemplateFormComponent
  ],
  imports: [
    CommonModule,
    TemplateFormRoutingModule
  ],
  providers:[],
  exports:[]
})
export class TemplateFormModule { }
