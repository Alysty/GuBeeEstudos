import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SecondTestComponent } from './second-test.component';
import {SecondTestService} from "./second-test.service";

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [
    SecondTestComponent
  ],
  exports:[
    SecondTestComponent
  ],
  providers:[
    SecondTestService
  ]
})
export class SecondTestModule { }
