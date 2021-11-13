import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Response } from '../model/response'
import { map } from 'rxjs/operators';
import { Author } from '../model/author';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  
  constructor(private http: HttpClient) { }

  getBlogs(){
    return this.http.get<Response[]>('/api/blogs/');
  }
 
  getAuthors(){
    return this.http.get<Author[]>('/api/authors/')
  }
}
