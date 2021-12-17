import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {BlogEntry} from '../model/blog-entry';
import {Author} from '../model/author';
import {BlogStats} from '../model/blog-stats.model';
import {Blog} from '../model/blog';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) {
  }

  getBlogs(): Observable<BlogEntry[]> {
    return this.http.get<BlogEntry[]>('/api/blogs/');
  }

  getBlog(id: number): Observable<BlogEntry> {
    return this.http.get<BlogEntry>('/api/blogs/' + id);
  }

  getAuthors() {
    return this.http.get<Author[]>('/api/authors/');
  }

  getBlogStats(): Observable<BlogStats> {
    return this.http.get<BlogStats>('/api/blogs/stats');
  }
}
