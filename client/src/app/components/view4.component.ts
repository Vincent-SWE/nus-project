import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view4',
  templateUrl: './view4.component.html',
  styleUrls: ['./view4.component.css']
})
export class View4Component {

  constructor(private router: Router) { }


  gotoAppointmentsbooking() {
    console.log('Going to Appointmentsbooking!')
    this.router.navigate(['/appointmentsbooking']);
  }

  

}
