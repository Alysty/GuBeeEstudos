import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { CounterComponent } from './counter/counter.component';
import { DiretivaNgifComponent } from './diretiva-ngif/diretiva-ngif.component';
import { DirectiveNgswitchComponent } from './directive-ngswitch/directive-ngswitch.component';
import { DirectiveNgforComponent } from './directive-ngfor/directive-ngfor.component';
import { DirectiveNgclassComponent } from './directive-ngclass/directive-ngclass.component';
import { DirectiveNgstyleComponent } from './directive-ngstyle/directive-ngstyle.component';
import {FormsModule} from "@angular/forms";
import { ElvisOperatorComponent } from './elvis-operator/elvis-operator.component';
import { YellowBackgroundDirective } from './shared/yellow-background.directive';
import { CustomDirectivesComponent } from './custom-directives/custom-directives.component';
import { HighlightMouseDirective } from './shared/highlight-mouse.directive';
import { HighlightDirective } from './shared/highlight.directive';
import { NgElseDirective } from './shared/ng-else.directive';
import { CursosComponent } from './cursos/cursos.component';
import {CursosService} from "./cursos/cursos.service";

@NgModule({
  declarations: [
    AppComponent,
    CounterComponent,
    DiretivaNgifComponent,
    DirectiveNgswitchComponent,
    DirectiveNgforComponent,
    DirectiveNgclassComponent,
    DirectiveNgstyleComponent,
    ElvisOperatorComponent,
    YellowBackgroundDirective,
    CustomDirectivesComponent,
    HighlightMouseDirective,
    HighlightDirective,
    NgElseDirective,
    CursosComponent
  ],
  imports: [
    BrowserModule,
    NgbModule,
    FormsModule
  ],
  providers: [CursosService],
  bootstrap: [AppComponent]
})
export class AppModule { }
