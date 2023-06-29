import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view0',
  templateUrl: './view0.component.html',
  styleUrls: ['./view0.component.css']
})
export class View0Component {

  constructor(private router: Router) { }


  clickA() {
    console.log('Blood type A was clicked!')
    this.router.navigate(['/A']);
  }

  clickB() {
    console.log('Blood type B was clicked!');
  }

  clickAB() {
    console.log('Blood type AB was clicked!');
  }

  clickO() {
    console.log('Blood type O was clicked!');
  }



















}
