import {Author} from "./author";
import {Location} from "./location";
import {Blog} from "./blog";
import {CommonModule} from '@angular/common';
import {NgModule} from "@angular/core";

@NgModule({
  imports: [CommonModule]
})
export class Response {
  constructor(public blog?: Blog,
              public author?: Author,
              public location?: Location) {
  }


}
