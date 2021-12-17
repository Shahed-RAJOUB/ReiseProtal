import { Component, OnInit } from '@angular/core';
import {AuthorService} from '../../service/author.service';
import {UserService} from '../../service/user.service';
import {ActivatedRoute, Router} from '@angular/router';
import {take} from 'rxjs/operators';
import {Observable} from 'rxjs';
import {BlogEntry} from '../../model/blog-entry';

@Component({
  selector: 'app-view-blog',
  templateUrl: './view-blog.component.html',
  styleUrls: ['./view-blog.component.css']
})
export class ViewBlogComponent {

  blogEntry$?: Observable<BlogEntry>;

  constructor(private userService: UserService,
              private route: ActivatedRoute) {
    route.params
      .pipe(take(1))
      .subscribe(param => this.blogEntry$ = userService.getBlog(param.id));
  }
}
