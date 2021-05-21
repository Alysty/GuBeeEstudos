import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TemplateFormComponent } from './template-form.component';
import { TemplateFormRoutingModule } from "./template-form-routing.module";
import {FormsModule} from "@angular/forms";
import { FormDebugComponent } from '../shared/form-debug/form-debug.component';


@NgModule({
  declarations: [
    TemplateFormComponent,
    FormDebugComponent
  ],
  imports: [
    CommonModule,
    TemplateFormRoutingModule,
    FormsModule
  ],
  providers:[],
  exports: [
    FormDebugComponent
  ]
})
export class TemplateFormModule { }
