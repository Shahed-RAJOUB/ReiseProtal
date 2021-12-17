import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AuthorViewComponent } from './author-view/author-view.component';
import { UserViewComponent } from './user-view/user-view.component';
import { StatisticViewComponent } from './statistic-view/statistic-view.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { CommonModule, NgLocaleLocalization, NgLocalization } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { ViewBlogComponent } from './user-view/view-blog/view-blog.component';

@NgModule({
  declarations: [
    AppComponent,
    AuthorViewComponent,
    UserViewComponent,
    StatisticViewComponent,
    HeaderComponent,
    FooterComponent,
    ViewBlogComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    CommonModule,
    FormsModule
  ],
  providers: [{ provide: NgLocalization, useClass: NgLocaleLocalization }],
  bootstrap: [AppComponent]
})
export class AppModule { }
