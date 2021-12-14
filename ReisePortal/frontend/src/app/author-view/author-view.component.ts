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

  constructor(private authorService: AuthorService) { }

  ngOnInit(): void {
  }
  // @ts-ignore
  onSendBlog(data) {
    this.authorService.sendBlog(data)
  }
}
