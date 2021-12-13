import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Author } from '../model/author';
import { Blog } from '../model/blog';
import { Location } from '../model/location';
import { Response } from '../model/response';

@Injectable({
  providedIn: 'root'
})
export class AuthorService {

  constructor(private http: HttpClient) { }

  sendBlog(author: Author, location: Location, blog: Blog) {
    const headers = {'content-type': 'application/json'};
    // @ts-ignore
    const body = JSON.stringify(new Response(author , location , blog));
    return this.http.post<Response[]>('/api/blogs/', body , {headers});
  }
}
