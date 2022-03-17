import { ExperienceDialogComponent } from '../../modules/my-details/profile/experience-dialog/experience-dialog.component';
import { EducationDialogComponent } from '../../modules/my-details/profile/education-dialog/education-dialog.component';
import { DialogComponent } from '../../modules/job-listing/dialog/dialog.component';
import { ProfileComponent } from '../../modules/my-details/profile/profile.component';

import { MatStepperModule } from '@angular/material/stepper';
import { MyApplicationsComponent } from './../../modules/my-applications/my-applications.component';
import { JobListingComponent } from './../../modules/job-listing/job-listing.component';
import { MatSidenavModule } from '@angular/material/sidenav';
import { SharedModule } from './../../shared/shared.module';

import { RouterModule } from '@angular/router';
import { MaterialModule } from './../../material.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DefaultComponent } from './default.component';
import { DashboardComponent } from 'src/app/modules/dashboard/dashboard.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { MyDetailsComponent } from 'src/app/modules/my-details/my-details.component';
import { MyDetailsService } from 'src/app/modules/my-details/my-details.service';



@NgModule({
  declarations: [
    DefaultComponent,
    DashboardComponent,
    JobListingComponent,
    MyApplicationsComponent,
    MyDetailsComponent,
    ProfileComponent,
    DialogComponent,
    EducationDialogComponent,
    ExperienceDialogComponent,
  ],
  imports: [
    CommonModule,
    RouterModule,
    SharedModule,
    MaterialModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    MatStepperModule,


  ],
  providers: [MyDetailsService],
})
export class DefaultModule { }
