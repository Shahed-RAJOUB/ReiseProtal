import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthorService {
  baseURL='/blogs/'

  constructor() { }
}
