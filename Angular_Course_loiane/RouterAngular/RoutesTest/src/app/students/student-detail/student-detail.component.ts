import {Component, OnDestroy, OnInit} from '@angular/core';
import {Subscription} from "rxjs";
import {ActivatedRoute, Router} from "@angular/router";
import {StudentsService} from "../students.service";

@Component({
  selector: 'app-student-detail',
  templateUrl: './student-detail.component.html',
  styleUrls: ['./student-detail.component.css']
})
export class StudentDetailComponent implements OnInit, OnDestroy{

  student : any;
  // @ts-ignore
  subscription: Subscription;
  constructor(private route: ActivatedRoute,
              private studentsService: StudentsService) { }

  ngOnInit(): void {
    this.subscription = this.route.params.subscribe(
      (params)=>{
        this.student = this.studentsService.getStudent(params['id'])
      }
    );
  }
  ngOnDestroy(){
    this.subscription.unsubscribe();
  }
}
