import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserRegistrationService {

  constructor(private http:HttpClient) { }


  public doRegistration(user){
    return this.http.post("https://8080-afcacccbfeadafbceabebcaadcf.examlyiopb.examly.io/signup",user,{responseType:'text' as 'json'});
  }

  public getUsers(){
    return this.http.get("https://8080-afcacccbfeadafbceabebcaadcf.examlyiopb.examly.io/getusers");
  }

  public getUserByEmail(email){
    return this.http.get("https://8080-afcacccbfeadafbceabebcaadcf.examlyiopb.examly.io/finduser/"+email);
  }

  public deleteUser(id){
    return this.http.delete("https://8080-afcacccbfeadafbceabebcaadcf.examlyiopb.examly.io/cancel/"+id);
  }
}