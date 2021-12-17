import { NgModule} from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HeaderComponent} from "./header/header.component";
import {FooterComponent} from "./footer/footer.component";
import {AuthorViewComponent} from "./author-view/author-view.component";
import {UserViewComponent} from "./user-view/user-view.component";
import {StatisticViewComponent} from "./statistic-view/statistic-view.component";
import {ViewBlogComponent} from './user-view/view-blog/view-blog.component';

const routes: Routes = [
  {path: 'header', component: HeaderComponent},
  {path: 'footer', component: FooterComponent},
  {path: 'author-view', component: AuthorViewComponent},
  {path: 'user-view', component:UserViewComponent},
  {path: 'statistic-view', component: StatisticViewComponent},
  {path: 'blog/:id', component: ViewBlogComponent},
  {path: '**', component: UserViewComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
