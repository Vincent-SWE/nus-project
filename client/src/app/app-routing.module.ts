import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { View0Component } from './components/view0.component';
import { View1Component } from './components/view1.component';
import { View2Component } from './components/view2.component';
import { View3Component } from './components/view3.component';
import { View4Component } from './components/view4.component';
import { View5Component } from './components/view5.component';
import { View6Component } from './components/view6.component';

const routes: Routes = [

  {path:"", component: View0Component},
  {path:"A", component: View1Component},
  {path:"B", component: View2Component},
  {path:"AB", component: View3Component},
  {path:"O", component: View4Component},
  {path:"appointmentsbooking", component: View5Component},
  {path:"confirmation", component: View6Component},

  {path:"**", redirectTo:"/", pathMatch:"full"}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
