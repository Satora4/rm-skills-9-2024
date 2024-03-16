import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {HttpClientModule} from "@angular/common/http";
import {AnalysisComponent} from "./analysis/analysis.component";
import {AppRoutingModule} from "./app-routing.module";
import {AppComponent} from "./app.component";
import {BrowserModule} from "@angular/platform-browser";
import {ModalComponent} from "./modal/modal.component";
import {FormsModule} from "@angular/forms";

@NgModule({
  declarations: [AppComponent, AnalysisComponent, ModalComponent],
  imports: [
    AppRoutingModule,
    BrowserModule,
    CommonModule,
    HttpClientModule,
    FormsModule
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
