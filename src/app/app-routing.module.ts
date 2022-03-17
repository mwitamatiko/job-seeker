import { ProfileComponent } from './modules/my-details/profile/profile.component';

import { MyApplicationsComponent } from './modules/my-applications/my-applications.component';
import { JobListingComponent } from './modules/job-listing/job-listing.component';

import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DefaultComponent } from './layouts/default/default.component';
import { DashboardComponent } from './modules/dashboard/dashboard.component';
import { MyDetailsComponent } from './modules/my-details/my-details.component';

const routes: Routes = [
  {
    path: '',
    component: DefaultComponent,
    children: [
      {
        path: '',
        component: DashboardComponent
      },{
        path: 'details',
        component: MyDetailsComponent
      },{
        path: 'job_listing',
        component: JobListingComponent
      }
      ,{
        path: 'my_applications',
        component: MyApplicationsComponent
      },{
        path: 'profile',
        component: ProfileComponent
      },

    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
