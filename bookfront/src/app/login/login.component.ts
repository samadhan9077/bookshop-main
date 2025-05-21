import { Component } from '@angular/core';
import { Signup } from '../models/signup';
import { FormsModule } from '@angular/forms';
import { SignupService } from '../services/signup.service';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-login',
  imports: [FormsModule,CommonModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
s:Signup=new Signup()
constructor(private ss:SignupService,private router:Router)
{

}
submitdata(){
  this.ss.login(this.s.email,this.s.password).subscribe(data=>{
    if(data!=null)
    {
      alert("Login successful...")
      localStorage.setItem("email",this.s.email)
      this.router.navigate(["/"])
    }
    else
    {
      alert("Invalid email or password...")
    }
  })
}
}
