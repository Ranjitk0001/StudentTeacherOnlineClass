import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StudentComponent } from './student/student.component';
import { AppComponent } from './app.component';

const routes: Routes = [
  {path:'Student',component:StudentComponent},
  {path:'home',component:AppComponent},
  {path:'',redirectTo:'home',pathMatch:'full'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
