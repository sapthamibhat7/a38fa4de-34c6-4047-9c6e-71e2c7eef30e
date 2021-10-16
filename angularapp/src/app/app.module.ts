import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { AppComponent } from './app.component';
import {StorageServiceModule} from 'ngx-webstorage-service';
import {Router, Routes, RouterModule} from '@angular/router';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';

import { LoginComponent } from './Components/login/login.component';
import { RegisterComponent } from './Components/register/register.component';
import { NavigationComponent } from './Components/navigation/navigation.component';

const appRoutes:Routes=[
    { path: '',
      redirectTo: '/login',
      pathMatch: 'full'
    },
  {
    path:'login',
    component: LoginComponent
  },
  {
    path:'register',
    component: RegisterComponent
  }
];

@NgModule({
    imports: [
        BrowserModule,
        RouterModule,
        HttpClientModule,
        StorageServiceModule,
        RouterModule.forRoot(appRoutes),
        FormsModule,
        ReactiveFormsModule,
        BrowserAnimationsModule
      ],
    declarations: [
        AppComponent,
    NavigationComponent,
    LoginComponent,
    RegisterComponent
    ],
    providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { };
