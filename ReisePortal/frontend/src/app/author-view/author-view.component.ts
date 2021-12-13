import { Component, ElementRef, OnInit, ViewChildren } from '@angular/core';
import { FormBuilder, FormControlName, FormGroup } from '@angular/forms';
import { Author } from '../model/author';
import { Blog } from '../model/blog';
import { Location } from '../model/location';
import { Response } from '../model/response';
import { AuthorService } from '../service/author.service';

@Component({
  selector: 'app-author-view',
  templateUrl: './author-view.component.html',
  styleUrls: ['./author-view.component.css']
})
export class AuthorViewComponent implements OnInit {
  // @ts-ignore
  @ViewChildren(FormControlName, {read: ElementRef}) formInputElements: ElementRef[];
  // @ts-ignore
  BlogForm: FormGroup;
  author = new Author();
  location = new Location();
  blog = new Blog();

  constructor(private fb: FormBuilder ,  private authorService: AuthorService) { }

  ngOnInit(): void {
    this.BlogForm = this.fb.group({
      authorName: [''],
      authorEmail: [''],
      locationName: [''],
      locationCity: [''],
      locationStreet: [''],
      locationZip: [''],
      blogTitle: [''],
      blogText: [''],
    })
  }

  onSendBlog() {
    this.authorService.sendBlog(this.author , this.location , this.blog)
  }
}
