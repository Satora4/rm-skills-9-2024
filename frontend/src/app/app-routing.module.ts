import {NgModule} from '@angular/core';
import {UserComponent} from "./user/user.component";
import {RouterModule, Routes} from "@angular/router";

const routes: Routes = [
  { path: 'users', component: UserComponent },
  { path: '', redirectTo: '/users', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
