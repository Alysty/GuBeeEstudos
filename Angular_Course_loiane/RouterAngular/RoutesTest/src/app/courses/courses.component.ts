import { Component, OnInit } from '@angular/core';
import {CoursesService} from "./courses.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.css']
})
export class CoursesComponent implements OnInit {

  courses: any[] = [];
  // @ts-ignore
  page: number;
  // @ts-ignore
  subscription: Subscription;
  constructor(private coursesService:CoursesService,
              private route: ActivatedRoute,
              private router: Router) { }

  ngOnInit(): void {
    this.courses = this.coursesService.getCourses();

    this.subscription = this.route.queryParams.subscribe(
      (params)=>{
        this.page = Number(params['page'])
      }
    );
  }
  ngOnDestroy(){
    this.subscription.unsubscribe()
  }
  nextPage(){
    this.page += 1;
    this.router
      .navigate(
        ['/courses'],
        {queryParams: {page: this.page}})
      .catch()
  }
  previousPage(){
    this.page -= 1;
    this.router
      .navigate(
        ['/courses'],
        {queryParams: {page: this.page}})
      .catch()
  }
}
