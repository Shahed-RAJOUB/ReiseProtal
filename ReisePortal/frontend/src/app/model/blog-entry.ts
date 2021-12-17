import {Author} from './author';
import {Location} from './location';
import {Blog} from './blog';

export class BlogEntry {

  constructor(public blog: Blog,
              public author: Author,
              public location: Location) {
  }
}
