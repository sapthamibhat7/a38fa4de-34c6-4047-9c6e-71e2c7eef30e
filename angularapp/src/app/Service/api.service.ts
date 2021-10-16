import { Injectable, Inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../Model/user';
import { SESSION_STORAGE, StorageService } from 'ngx-webstorage-service';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private REG_API = "https://8080-afcacccbfeadafbceabebcaadcf.examlyiopb.examly.io/signup";
  private LOGU_API = "https://8080-afcacccbfeadafbceabebcaadcf.examlyiopb.examly.io/login";

  constructor(@Inject(SESSION_STORAGE) private storage: StorageService, private http: HttpClient) {

  }
  // Registering the users to the database
  register(user: User): Observable<any> {
    return this.http.post(this.REG_API,
      JSON.stringify(user),
      {
        headers:
          { 'Content-Type': 'application/json' }
      });
  }
  // validating user credentials
  userLogin(user: User): Observable<any> {
    return this.http.post(this.LOGU_API,
      JSON.stringify(user),
      {
        headers:
          { 'Content-Type': 'application/json' }
      });
  }

  // Authentication Methods 

  public isAuthenticated(): boolean {
    return this.getToken() !== null;
  }

  storeToken(token: string, auth_type: string) {
    this.storage.set("auth_token", token);
    this.storage.set("auth_type", auth_type);
  }

  getAuthType(): string {
    if (this.storage.get("auth_type") !== null) {
      return this.storage.get("auth_type");
    }
    return null;
  }


  getToken() {
    return this.storage.get("auth_token");
  }

  removeToken() {
    this.storage.remove("auth_type");
    return this.storage.remove("auth_token");
  }

}
