import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';


import { SecondTestModule} from './test-component/second-test/second-test.module'

@NgModule({
  declarations: [
    AppComponent

  ],
  imports: [
    BrowserModule,
    SecondTestModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
