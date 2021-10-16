import { Component, OnInit } from '@angular/core';
import { ApiService } from '../../Service/api.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {
  public loggedType: string;
  constructor(private auth: ApiService, private route: Router) {

    if (this.auth.getAuthType() == null) {
      this.loggedType = "home";
    } else {
      if (this.auth.getAuthType() == "employee") {
        this.loggedType = "employee";
      } else if (this.auth.getAuthType() == "hr") {
        this.loggedType = "hr";
      }
    }
  }
  ngOnInit() {
  }
  logout() {
    this.loggedType = "home";
    this.auth.removeToken();
    this.route.navigate(['/login']);
  }

}