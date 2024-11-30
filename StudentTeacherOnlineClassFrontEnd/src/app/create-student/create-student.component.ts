import { Component } from '@angular/core';
import { Student } from '../entityClass/student';
import { StudentService } from '../services/student.service';

@Component({
  selector: 'app-create-student',
  templateUrl: './create-student.component.html',
  styleUrl: './create-student.component.css'
})
export class CreateStudentComponent {
  student:Student=new Student();
  
  constructor(private studentService:StudentService){}
  saveStudent(){
    this.studentService.createStudent(this.student).subscribe(data=>{
      console.log(data);
    })
  }
  onSubmit(){
    this.saveStudent();
  }
}
