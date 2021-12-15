import {Component} from '@angular/core';
import {Observable} from 'rxjs';
import {UserService} from '../service/user.service';
import {BlogStats} from '../model/blog-stats.model';

@Component({
  selector: 'app-statistic-view',
  templateUrl: './statistic-view.component.html',
  styleUrls: ['./statistic-view.component.css']
})
export class StatisticViewComponent {

  blogStats$: Observable<BlogStats[]>;

  constructor(public userService: UserService) {
    this.blogStats$ = this.userService.getBlogStats();
  }

  getSpecificBlogStat(type: string, blogstats: BlogStats[]): any | undefined {
    console.log(blogstats);
    return blogstats.find(it => it.type === type)?.stats;
  }
}
