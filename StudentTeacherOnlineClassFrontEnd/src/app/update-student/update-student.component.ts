import { Component, OnInit } from '@angular/core';
import { StudentService } from '../services/student.service';
import { Student } from '../entityClass/student';
import { ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-update-student',
  templateUrl: './update-student.component.html',
  styleUrl: './update-student.component.css'
})
export class UpdateStudentComponent implements OnInit{

  ngOnInit(): void {
      this.sno=this.route.snapshot.params['sno'];

      this.studentService.getStudentById(this.sno).subscribe(data=>{
        this.student=data;
        console.log(this.student)
      })
  }
  sno:number=0;
  constructor(private route:ActivatedRoute,private studentService:StudentService){}
  student:Student=new Student();


  onSubmit(){
    this.studentService.updateStudent(this.sno,this.student).subscribe(data=>{
      console.log(data);
      
    })

  }
}
