import { HttpClient } from '@angular/common/http';
import { Injectable, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Student } from '../entityClass/student';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  constructor(private httpClient:HttpClient) { }
private baseUrl="http://localhost:8084/api/v1/"  
  
 
  getMedicine ():Observable<Student[]>{
    return this.httpClient.get<Student[]>(`${this.baseUrl}`+'showlist')
   }

   createStudent(student:Student):Observable<Student>{
    return this.httpClient.post<Student>(`${this.baseUrl}`+'insert',student)
   }

   getStudentById(sno:number):Observable<Student>{
    return this.httpClient.get<Student>(`${this.baseUrl}${sno}`)
   }

   updateStudent(sno:number,student:Student):Observable<Object>{
    return this.httpClient.put<Student>(`${this.baseUrl}${sno}`,student)
   }

}
