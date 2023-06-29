import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view5',
  templateUrl: './view5.component.html',
  styleUrls: ['./view5.component.css']
})
export class View5Component {

  constructor(private router: Router) { }


  gotoConfirmation() {
    console.log('Going to Confirmation Page!')
    this.router.navigate(['/confirmation']);
  }







}
