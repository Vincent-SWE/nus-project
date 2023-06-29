import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view3',
  templateUrl: './view3.component.html',
  styleUrls: ['./view3.component.css']
})
export class View3Component {

  constructor(private router: Router) { }


  gotoAppointmentsbooking() {
    console.log('Going to Appointmentsbooking!')
    this.router.navigate(['/appointmentsbooking']);
  }



}
