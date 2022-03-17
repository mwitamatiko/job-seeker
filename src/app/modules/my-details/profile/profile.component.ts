import { MatDialog } from '@angular/material/dialog';
import { HttpErrorResponse, HttpParams } from '@angular/common/http';
import { Component, OnInit, ViewChild } from '@angular/core';
import { FormArray, FormBuilder, Validators } from '@angular/forms';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatHorizontalStepper } from '@angular/material/stepper';
import { MatTableDataSource } from '@angular/material/table';
import { ActivatedRoute } from '@angular/router';
import { EducationDialogComponent } from './education-dialog/education-dialog.component';
import { ExperienceDialogComponent } from './experience-dialog/experience-dialog.component';
import { MyDetailsService } from '../my-details.service';
import { MatSnackBar } from '@angular/material/snack-bar';

export interface Education{

  institution_level:any
  institution_name:any
  enrolled_year:any
  graduated_year:any
  certification:any
  gpa:any

}

export interface Experience{
  id:any,
  company_name:any
  work_position:any
  years_of_experience:any
  referee_email:any
  referee_name:any
  referee_phone:any

}

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  @ViewChild('stepper') stepper!: MatHorizontalStepper;
  @ViewChild(MatPaginator) paginator !: MatPaginator;
  @ViewChild(MatSort) sort !: MatSort;

  educationTableArray: string[] = ['institution_level','institution_name', 'enrolled_year','graduated_year','certification','gpa','action'];
  experienceTableArray: string[] = ['company_name','work_position','years_of_experience','referee_email','referee_name','referee_phone','action'];
  // experienceDatasource!: MatTableDataSource<Experience>
  dataSource !: MatTableDataSource<Experience>;
  dataSource1!: MatTableDataSource<Education>;
  experienceArray: any;
  educationArray: any;
  educations: any;
  id: any;
  experiences: any;
  error: any;

  constructor(
    private formBuilder: FormBuilder,
    private service : MyDetailsService,
    private actRoute: ActivatedRoute,
    private dialog: MatDialog,
    private snackBar: MatSnackBar,

  ) { }

  ngOnInit(): void {
    // this.onAddSubEducationForm();

    this.getData();

  }

  responseData: any

  genderChoice!: string;
  genders: string[] = ['Male', 'Female', 'Intersex'];

  // personal information

  personalInfoForm = this.formBuilder.group({
    id:[''],
    applicant_id:[''],
    first_name: ['',Validators.required],
    last_name: ['',Validators.required],
    middle_name: ['',Validators.required],
    religion: ['',Validators.required],
    national_id: ['',Validators.required],
    // gender: ['',Validators.required]
  })



// Home Address
homeForm = this.formBuilder.group({
  id:[''],
  applicant_id:[''],
  nationality: ['',Validators.required],
  home_county: ['',Validators.required],
  sub_county: ['',Validators.required],
  current_country: ['',Validators.required],
  current_county: ['',Validators.required],
  current_sub_county: ['',Validators.required],
  postal_address: ['',Validators.required],
  city: ['',Validators.required],
  postal_code: ['',Validators.required]
})


// contact information
contactForm = this.formBuilder.group({
  id:[''],
   applicant_id:[''],
  personal_phone:['',Validators.required],
  home_telephone:['',Validators.required],
  other_telephone: ['',Validators.required],
  email_address:['',Validators.required],
  linkedin:['',Validators.required],
  github:['',Validators.required],
})
// Education
educationForm = this.formBuilder.group({
  id:[''],
  applicant_id:[''],
  applicant_educations: this.formBuilder.array([]),
})

get f() { return this.educationForm.controls; }
get t() { return this.f.applicant_educations as FormArray; }

onAddSubEducationForm(){
  this.t.push(
   this.formBuilder.group({
      id:[''],
      applicant_id:[''],
      institution_level: ['',Validators.required],
      institution_name: ['',Validators.required],
      enrolled_year: ['',Validators.required],
      graduated_year: ['',Validators.required],
      certification: ['',Validators.required],
      gpa: ['',Validators.required],
    })
  )
}
onRemoveEducation(i:any,form_id:any){
  if(!form_id){
    this.t.removeAt(i);
  }else{
    if(window.confirm("Are you sure to delete this education?")){
      // this.onDeleteEducation(form_id);
      this.t.removeAt(i);
    }
  }
}
// Experience
experienceEmptyForm = this.formBuilder.group({
  id:[''],
  applicant_id:[''],
  applicant_experience: this.formBuilder.array([]),
})
get e() { return this.experienceEmptyForm.controls; }
get e1() { return this.e.applicant_experience as FormArray; }

onAddExperienceForm(){
  this.e1.push(
    this.formBuilder.group({
      id:[''],
      applicant_id:[''],
      company_name:['',Validators.required],
      work_position:['',Validators.required],
      years_of_experience:['',Validators.required],
      referee_email:['',Validators.required],
      referee_name:['',Validators.required],
      referee_phone:['',Validators.required],
    })
  )
}
onRemoveExperience(i:any,form_id:any){

  if(!form_id){
    this.e1.removeAt(i);
  }else{
    if(window.confirm("Are you sure to delete this experience?")){
      // this.onDeleteExperience(form_id);
      this.e1.removeAt(i);
    }
  }

}


// call the api
getData(){
  let id = 1
  this.service.getApplicantById(id).subscribe(
    response=>{
      this.responseData = response;
      this.educations = this.responseData.applicant_educations;
      console.log("main response",response);
      console.log("education array",this.educations);



      this.experiences = this.responseData.applicant_experiences;


      this.onLoopExperienceArray(this.experiences)

        // personal information

      this.personalInfoForm = this.formBuilder.group({
        id:[this.responseData.id],
        applicant_id:[this.responseData.applicant_id],
        first_name: [this.responseData.first_name],
        last_name: [this.responseData.last_name],
        middle_name: [this.responseData.middle_name],
        religion: [this.responseData.religion],
        national_id: [this.responseData.national_id],
        // gender: ['',Validators.required]
      })
      // Home Address
      this.homeForm = this.formBuilder.group({
        id:[this.responseData.id],
        applicant_id:[this.responseData.applicant_id],
        nationality: [this.responseData.nationality],
        home_county: [this.responseData.home_county],
        sub_county: [this.responseData.sub_county],
        current_country: [this.responseData.current_country],
        current_county: [this.responseData.current_county],
        current_sub_county: [this.responseData.current_sub_county],
        postal_address: [this.responseData.postal_address],
        city: [this.responseData.city],
        postal_code: [this.responseData.postal_code]
      })
      // contact information
      this.contactForm = this.formBuilder.group({
        id:[this.responseData.id],
        applicant_id:[this.responseData.applicant_id],
        personal_phone:[this.responseData.personal_phone],
        home_telephone:[this.responseData.home_telephone],
        other_telephone: [this.responseData.other_telephone],
        email_address:[this.responseData.email_address],
        linkedin:[this.responseData.linkedin],
        github:[this.responseData.github],
      })
      // Education
      this.educationForm = this.formBuilder.group({
        id:[this.responseData.id],
        applicant_id:[this.responseData.applicant_id],
        highest_level_of_education: [this.responseData.highest_level_of_education],
        course_programme: [this.responseData.course_programme],
        enrollment_status: [this.responseData.enrollment_status],
        applicant_educations: this.formBuilder.array([]),

      })
      this.onLoopEducationArray(this.educations);

    }
  )
}

onLoopEducationArray(data:any){
  let formEntries = Object.keys(data).length
  console.log("No. form entries",formEntries);

  for (let i = 0; i < formEntries; i++) {
     let res = data[i]
     console.log("how many times",i);

    this.onInitAddSubEducationForm(res);
  }
}

onInitAddSubEducationForm(data:any){
  console.log("subEducation",data);
  console.log("subEducation id",data.id);


  this.t.push(
   this.formBuilder.group({
      id:[''],
      applicant_id:[''],
      institution_level: ['',Validators.required],
      institution_name: ['',Validators.required],
      enrolled_year: ['',Validators.required],
      graduated_year: ['',Validators.required],
      certification: ['',Validators.required],
      gpa: ['',Validators.required],
      // applicant_id:[data.applicant_id],
      // institution_level: [data.institution_level],
      // institution_name: [data.institution_name],
      // enrolled_year: [data.enrolled_year],
      // graduated_year: [data.graduated_year],
      // certification: [data.certification],
      // gpa: [data.gpa],
    })
  )
}
onLoopRemoveEducation(i:any,form_id:any){
  if(!form_id){
    this.t.removeAt(i);
  }else{
    if(window.confirm("Are you sure to delete this education?")){
      // this.onDeleteEducation(form_id);
      this.t.removeAt(i);
    }
  }
}

onLoopExperienceArray(data:any){
  let formEntries = Object.keys(data).length
  for (let i = 0; i < formEntries; i++) {
     let res = data[i]
    this.onInitAddExperienceForm(res);
  }
}
onInitAddExperienceForm(data:any){
  this.e1.push(
    this.formBuilder.group({
      id:[data.id],
      applicant_id:[data.applicant_id],
      company_name:[data.company_name],
      work_position:[data.work_position],
      years_of_experience:[data.years_of_experience],
      referee_email:[data.referee_email],
      referee_name:[data.referee_name],
      referee_phone:[data.referee_phone],
    })
  )
}
onLoopRemoveExperience(i:any,form_id:any){
  if(!form_id){
    this.t.removeAt(i);
  }else{
    if(window.confirm("Are you sure to delete this education?")){
      // this.onDeleteEducation(form_id);
      this.t.removeAt(i);
    }
  }
}


}


