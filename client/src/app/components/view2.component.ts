import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view2',
  templateUrl: './view2.component.html',
  styleUrls: ['./view2.component.css']
})
export class View2Component {

  constructor(private router: Router) { }


  gotoAppointmentsbooking() {
    console.log('Going to Appointmentsbooking!')
    this.router.navigate(['/appointmentsbooking']);
  }






}
