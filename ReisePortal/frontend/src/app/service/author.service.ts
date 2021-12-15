import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {BlogEntry} from '../model/blog-entry';

@Injectable({
  providedIn: 'root'
})
export class AuthorService {

  constructor(private http: HttpClient) {
  }

  sendBlog(blogEntry: BlogEntry) {
    return this.http.post<void>('/api/blogs/', blogEntry);
  }

}
