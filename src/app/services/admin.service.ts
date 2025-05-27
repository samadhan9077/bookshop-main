import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Admin } from '../models/admin';
import ps from '@angular/common/locales/ps';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdminService {
serverurl="http://localhost:9000/bookshop"
  constructor(private http:HttpClient) { }
login(em:any,ps:any):Observable<Admin>
  {
    return this.http.get<Admin>(this.serverurl+"/adminlogin/"+em+"/"+ps)
  }
}
