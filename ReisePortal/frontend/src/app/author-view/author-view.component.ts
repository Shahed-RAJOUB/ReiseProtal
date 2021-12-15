import {Component} from '@angular/core';
import {AuthorService} from '../service/author.service';
import {BlogEntry} from '../model/blog-entry';
import {Router} from '@angular/router';

@Component({
  selector: 'app-author-view',
  templateUrl: './author-view.component.html',
  styleUrls: ['./author-view.component.css']
})
export class AuthorViewComponent {

  constructor(private authorService: AuthorService,
              private router: Router) {
  }

  onSendBlog(data: any) {
    console.log(data);
    const blogEntry = {
      blog: {
        blogText: data.text,
        blogTitle: data.title
      },
      author: {
        authorEmail: data.email,
        authorName: data.authorName
      },
      location: {
        locationName: data.locationName,
        locationCity: data.locationCity,
        locationStreet: data.locationStreet,
        locationZip: data.locationZip
      }
    } as BlogEntry;
    this.authorService.sendBlog(blogEntry).subscribe(
      res => this.router.navigateByUrl('/user-view'),
      err => alert('Exception happened :('));
  }
}
