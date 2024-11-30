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
}
