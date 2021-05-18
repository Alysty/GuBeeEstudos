import { Component, OnInit } from '@angular/core';
import {CoursesService} from "../courses/courses.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-course-detail',
  templateUrl: './course-detail.component.html',
  styleUrls: ['./course-detail.component.css']
})
export class CourseDetailComponent implements OnInit {
  // @ts-ignore
  id:number;
  // @ts-ignore
  subscription: Subscription;
  course: any;
  constructor(private courseService: CoursesService,
              private route:ActivatedRoute,
              private router:Router) { }

  ngOnInit(): void {
    this.subscription = this.route.params.subscribe(
      (param:any)=>{
        this.id = param['id']
        this.course = this.courseService.getCourse(this.id)
        if(this.course == null){
          this.router.navigate(['/notFound']).catch()
        }
      }
    )

  }

}
