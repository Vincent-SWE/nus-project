import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { View0Component } from './components/view0.component';
import { View1Component } from './components/view1.component';
import { MaterialModule } from './material.module';
import { View2Component } from './components/view2.component';
import { View3Component } from './components/view3.component';
import { View4Component } from './components/view4.component';
import { View5Component } from './components/view5.component';
import { View6Component } from './components/view6.component';

@NgModule({
  declarations: [
    AppComponent,
    View0Component,
    View1Component,
    View2Component,
    View3Component,
    View4Component,
    View5Component,
    View6Component
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    ReactiveFormsModule,
    MaterialModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
