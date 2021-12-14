import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Author } from '../model/author';
import {Response } from '../model/response'
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-statistic-view',
  templateUrl: './statistic-view.component.html',
  styleUrls: ['./statistic-view.component.css']
})
export class StatisticViewComponent implements OnInit {

  Authors$: Observable<Author[]> | undefined;
  blogsVisits$: Observable<any> | undefined;
  FamousblogTitle$: Observable<any> | undefined;
  FamousLocation$: Observable<any> | undefined;

  constructor(public userService :UserService) { }

  ngOnInit(): void {
    this.blogsVisits$= this.userService.getBlogsVisits();
    this.FamousblogTitle$= this.userService.getPopularBlog();
    this.FamousLocation$= this.userService.getPopularLocation();
    this.Authors$= this.userService.getAuthors();
  }

}
