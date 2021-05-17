import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { CounterComponent } from './counter/counter.component';
import { DiretivaNgifComponent } from './diretiva-ngif/diretiva-ngif.component';
@NgModule({
  declarations: [
    AppComponent,
    CounterComponent,
    DiretivaNgifComponent
  ],
  imports: [
    BrowserModule,
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
