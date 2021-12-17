import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Location} from '../model/location';
import {Observable} from 'rxjs';
import {Author} from '../model/author';
import {Blog} from '../model/blog';

@Injectable({
  providedIn: 'root'
})
export class AuthorService {

  constructor(private http: HttpClient) {
  }

  sendBlog(blog: Blog) {
    return this.http.post<void>('/api/blogs/', blog);
  }

  getAllLocations(): Observable<Location[]> {
    return this.http.get<Location[]>('/api/locations/');
  }

  getAllAuthors(): Observable<Author[]> {
    return this.http.get<Author[]>('/api/authors/');
  }
}
