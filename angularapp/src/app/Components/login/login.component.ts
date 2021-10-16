import { Component, OnInit } from '@angular/core';
import { ApiService } from '../../Service/api.service';
import { Router } from '@angular/router';
import { FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public loginForm: any;
  error = false;
  constructor(private apiService: ApiService,
    private router: Router,
    private formBuilder: FormBuilder) {
    this.createForm();
  }

  createForm() {
    this.loginForm = this.formBuilder.group({
      email: ['', [Validators.required,Validators.email]],
      password: ['', [Validators.minLength(5),Validators.required]],
    });
  }
  login(): void {
    this.apiService.userLogin(this.loginForm.value).
      subscribe(res => {
        if (res.status == "200") {
          this.apiService.storeToken(res.auth_TOKEN, "employee");
          this.router.navigate(['/home']);
          this.error = false;
        }
      },
        err => {
          console.log(err);
      });
  }
}