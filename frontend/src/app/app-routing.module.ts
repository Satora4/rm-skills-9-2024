import {NgModule} from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {AnalysisComponent} from "./analysis/analysis.component";

const routes: Routes = [
  { path: 'analysis', component: AnalysisComponent },
  { path: '', redirectTo: '/analysis', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
