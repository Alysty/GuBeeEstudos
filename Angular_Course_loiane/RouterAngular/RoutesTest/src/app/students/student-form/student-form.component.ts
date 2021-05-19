import {Component, OnDestroy, OnInit} from '@angular/core';
import {StudentsService} from "../students.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-student-form',
  templateUrl: './student-form.component.html',
  styleUrls: ['./student-form.component.css']
})
export class StudentFormComponent implements OnInit, OnDestroy{
  student : any;
  // @ts-ignore
  subscription: Subscription;
  constructor(private route: ActivatedRoute,
              private studentsService: StudentsService) { }
  ngOnInit(): void {
    this.subscription = this.route.params.subscribe(
      (params)=>{
        this.student = this.studentsService.getStudent(params['id'])
        if(this.student == null){
          this.student = {}
        }
      }
    );
  }


  ngOnDestroy(){
    this.subscription.unsubscribe();
  }
}
