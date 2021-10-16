import { Component, OnInit } from '@angular/core';
import { ApiService } from '../../Service/api.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  public registerForm: any;
  public errorMessage: string;
  constructor(private apiService: ApiService,
    private router: Router,
    private formBuilder: FormBuilder) {
    this.createForm();
  }
  checkIfMatchingPasswords(passwordKey: string, passwordConfirmationKey: string) {
    return (group: FormGroup) => {
      let passwordInput = group.controls[passwordKey],
          passwordConfirmationInput = group.controls[passwordConfirmationKey];
      if (passwordInput.value !== passwordConfirmationInput.value) {
        return passwordConfirmationInput.setErrors({notEquivalent: true})
      }
      else {
          return passwordConfirmationInput.setErrors(null);
      }
    }
  }

  createForm() {
    this.registerForm = this.formBuilder.group({
      email: ['', [Validators.required,Validators.email]],
      password: ['', [Validators.minLength(5),Validators.required]],
      userName: ['', Validators.required],
      mobileNumber: ['', [Validators.required, Validators.pattern('^[6|7|8|9][0-9]*'), Validators.minLength(10), Validators.maxLength(10)]],
      userType: ['employee', Validators.required],
      confirmPassword: ['', Validators.required]
    },{validator: this.checkIfMatchingPasswords('password', 'confirmPassword')});
  }

  Details: any;
  register(): void {

    this.apiService.register(this.registerForm.value).
      subscribe(res => {
        if (res.status == "400") {
          console.log("Details cannot be empty");
        } else {
          this.Details = 1;
          this.router.navigate(['/login']);
        }
      },
        err => {
          alert("An error has occured, Please try again !!!");
        });
  }
}