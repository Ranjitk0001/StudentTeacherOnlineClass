import { Component, OnInit } from '@angular/core';
import { Student } from '../entityClass/student';
import { StudentService } from '../services/student.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrl: './student.component.css'
})
export class StudentComponent implements OnInit{
   students :Student[]=[];
   constructor(private studentService:StudentService,private router:Router){}
     ngOnInit(): void {
      this.getStudent();
     }

     getStudent(){
      this.studentService.getMedicine().subscribe(data=>{
        this.students=data;
      })
    }

    update(sno:number){
      this.router.navigate(['updateStudent',sno])
    
  }
  }
