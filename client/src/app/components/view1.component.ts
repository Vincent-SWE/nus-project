import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view1',
  templateUrl: './view1.component.html',
  styleUrls: ['./view1.component.css']
})
export class View1Component {

  
  constructor(private router: Router) { }


  gotoAppointmentsbooking() {
    console.log('Going to Appointmentsbooking!')
    this.router.navigate(['/appointmentsbooking']);
  }



}
