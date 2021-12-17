import {Component} from '@angular/core';
import {Observable} from 'rxjs';
import {UserService} from '../service/user.service';
import {BlogStats} from '../model/blog-stats.model';
import {LocationStat} from "../model/location-stat";

@Component({
  selector: 'app-statistic-view',
  templateUrl: './statistic-view.component.html',
  styleUrls: ['./statistic-view.component.css']
})
export class StatisticViewComponent {

  blogStats$: Observable<BlogStats>;

  constructor(public userService: UserService) {
    this.blogStats$ = this.userService.getBlogStats();
  }
}
