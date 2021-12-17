import {Component, OnInit} from '@angular/core';
import {Observable} from 'rxjs';
import {BlogEntry} from '../model/blog-entry';
import {UserService} from '../service/user.service';
import {Author} from '../model/author';
import {Route, Router} from '@angular/router';

@Component({
  selector: 'app-user-view',
  templateUrl: './user-view.component.html',
  styleUrls: ['./user-view.component.css']
})
export class UserViewComponent implements OnInit {

  blogs$: Observable<BlogEntry[]> | undefined;
  Authors$: Observable<Author[]> | undefined;

  constructor(private userService: UserService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.blogs$ = this.userService.getBlogs();
    this.Authors$ = this.userService.getAuthors();
  }

  openBlog(id: number | undefined): void {
    if (id) {
      this.router.navigate(['/blog', id]);
    }
  }

}
