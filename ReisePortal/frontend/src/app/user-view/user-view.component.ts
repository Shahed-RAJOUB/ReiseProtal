import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user-view',
  templateUrl: './user-view.component.html',
  styleUrls: ['./user-view.component.css']
})
export class UserViewComponent implements OnInit {

  constructor() { }
  status = false;
  ngOnInit(): void {
  }
  clickEvent(): any {
    this.status = !this.status;
  }

}
