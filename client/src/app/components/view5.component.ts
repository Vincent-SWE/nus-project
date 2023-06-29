import { Component } from '@angular/core';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSelectModule } from '@angular/material/select';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view5',
  templateUrl: './view5.component.html',
  styleUrls: ['./view5.component.css'],
})
export class View5Component {

  constructor(private router: Router) { }

  selected = 'option2';

  gotoConfirmation() {
    console.log('Going to Confirmation Page!')
    this.router.navigate(['/confirmation']);
  }


  





}
