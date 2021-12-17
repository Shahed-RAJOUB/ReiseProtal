import {Component} from '@angular/core';
import {AuthorService} from '../service/author.service';
import {Router} from '@angular/router';
import {Observable} from 'rxjs';
import {Location} from '../model/location';
import {Author} from '../model/author';
import {Blog} from '../model/blog';

@Component({
  selector: 'app-author-view',
  templateUrl: './author-view.component.html',
  styleUrls: ['./author-view.component.css']
})
export class AuthorViewComponent {

  locations$: Observable<Location[]>;
  authors$: Observable<Author[]>;

  constructor(private authorService: AuthorService,
              private router: Router) {
    this.locations$ = authorService.getAllLocations();
    this.authors$ = authorService.getAllAuthors();
  }

  onSendBlog(data: any) {
    const blogEntry = {
      authorId: data.authorId,
      locationId: data.locationId,
      blogText: data.text,
      blogTitle: data.title,
    } as Blog;
    this.authorService.sendBlog(blogEntry).subscribe(
      res => this.router.navigateByUrl('/user-view'),
      err => alert('Exception happened :('));
  }
}
