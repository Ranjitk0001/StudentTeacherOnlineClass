import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StudentComponent } from './student/student.component';
import { AppComponent } from './app.component';
import { CreateStudentComponent } from './create-student/create-student.component';

const routes: Routes = [
  {path:'Student',component:StudentComponent},
  // {path:'home',component:AppComponent},
  {path:'',redirectTo:'home',pathMatch:'full'},
  {path:'createStudent',component:CreateStudentComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
