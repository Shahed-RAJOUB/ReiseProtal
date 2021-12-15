import {Component, OnInit} from '@angular/core';
import {Observable} from 'rxjs';
import {BlogEntry} from '../model/blog-entry';
import {UserService} from '../service/user.service';
import {Author} from '../model/author';

@Component({
  selector: 'app-user-view',
  templateUrl: './user-view.component.html',
  styleUrls: ['./user-view.component.css']
})
export class UserViewComponent implements OnInit {

  blogs$: Observable<BlogEntry[]> | undefined;
  Authors$: Observable<Author[]> | undefined;

  constructor(public userService: UserService) {
  }

  status = false;

  ngOnInit(): void {
    this.blogs$ = this.userService.getBlogs();
    this.Authors$ = this.userService.getAuthors();
  }

  //TODO: add date and add update function for review
  clickEvent(id: any): any {
    this.status = !this.status;
  }

}
