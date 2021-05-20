import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {path: 'dataForm',
    loadChildren: () => import('./data-form/data-form.module').then(m => m.DataFormModule)},
  {path: 'templateForm',
    loadChildren: () => import('./template-form/template-form.module').then(m => m.TemplateFormModule)},
  {path: '', pathMatch: 'full', redirectTo: 'templateForm'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
