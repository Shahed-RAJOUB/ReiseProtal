import { Component, OnInit } from '@angular/core';
import {Observable} from 'rxjs';
import {Response } from '../model/response'
import { UserService } from '../service/user.service';
import { CommonModule } from '@angular/common';
import { Blog } from '../model/blog';
import { Author } from '../model/author';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-user-view',
  templateUrl: './user-view.component.html',
  styleUrls: ['./user-view.component.css']
})
export class UserViewComponent implements OnInit {

  blogs$: Observable<Response[]> | undefined;
  Authors$: Observable<Author[]> | undefined;

  constructor(public userService :UserService) {
  }
  status = false;
  ngOnInit(): void {
    this.blogs$= this.userService.getBlogs();
    this.Authors$= this.userService.getAuthors();
  }
  //TODO: add date and add update function for review 
  clickEvent(): any {
    this.status = !this.status;
  }

}
