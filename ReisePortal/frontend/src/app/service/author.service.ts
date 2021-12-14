import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthorService {

  constructor(private http: HttpClient) { }

  sendBlog(data: any) {
    this.http.post('/api/blogs/', data).subscribe((results)=>{
      console.log(results)
    })
  }

}
