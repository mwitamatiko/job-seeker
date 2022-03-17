
import { Component, OnInit, ViewChild } from '@angular/core';
import {FormArray, FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {STEPPER_GLOBAL_OPTIONS} from '@angular/cdk/stepper';
import { MatHorizontalStepper } from '@angular/material/stepper';
import { MyDetailsService } from './my-details.service';
import { HttpErrorResponse } from '@angular/common/http';
import { Applicant } from './user';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-my-details',
  templateUrl: './my-details.component.html',
  styleUrls: ['./my-details.component.css'],
  providers: [
    {
      provide: STEPPER_GLOBAL_OPTIONS,
      useValue: {showError: true},
    },
  ],
})
export class MyDetailsComponent implements OnInit {

  @ViewChild('stepper') stepper!: MatHorizontalStepper;

  public addMore!: FormGroup;

  constructor(
    private service : MyDetailsService,
    private formBuilder: FormBuilder,
    private actRoute: ActivatedRoute,


    ) { }

  ngOnInit(): void {
    this.onPersonalInfoFormInit();
    this.onHomeAddressInit();
    this.onContactInfoInit();
    this.onFormInitEducationFirstForm();
    this.onFormInitEducationSecondForm();
    this.onExperienceInit();

  }


  genderArray: string[] = ['Male', 'Female', 'Intersex'];
  religionArray: any = ['Christian','Muslim','Hindu','Other']

  // personal information

  personalInfoForm = this.formBuilder.group({
    first_name: ['',Validators.required],
    last_name: ['',Validators.required],
    middle_name: ['',Validators.required],
    religion: ['',Validators.required],
    national_id: ['',Validators.required],
    gender: ['',Validators.required]
  })


 onPersonalInfoFormInit(){
    this.personalInfoForm = this.formBuilder.group({
      first_name: ['',Validators.required],
      last_name: ['',Validators.required],
      middle_name: ['',Validators.required],
      religion: ['',Validators.required],
      national_id: ['',Validators.required],
      gender: ['',Validators.required]
  });
}

// Home Address

homeForm = this.formBuilder.group({
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

onHomeAddressInit(){
  this.homeForm = this.formBuilder.group({
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
}

// contact information
contactForm = this.formBuilder.group({
  personal_phone:['',Validators.required],
  home_telephone:['',Validators.required],
  other_telephone: ['',Validators.required],
  email_address:['',Validators.required],
  linkedin:['',Validators.required],
  github:['',Validators.required],
})

onContactInfoInit(){
  this.contactForm = this.formBuilder.group({
    personal_phone:['',Validators.required],
    home_telephone:['',Validators.required],
    other_telephone: ['',Validators.required],
    email_address:['',Validators.required],
    linkedin:['',Validators.required],
    github:['',Validators.required],
  })
}

// Academics and Documents

educationFirstForm = this.formBuilder.group({
  highest_level_of_education: ['',Validators.required],
  course_programme: ['',Validators.required],
  enrollment_status: ['',Validators.required],
  // resume: ['',Validators.required],
  // cover_letter: ['',Validators.required],
  // transcripts: ['',Validators.required],

  // applicant_educations:new FormArray([])
  applicant_educations: this.formBuilder.array([]),
});

get f1() { return this.educationFirstForm.controls; }
get t2() { return this.f1.applicant_educations as FormArray; }

// get applicant_educations(){
//   return this.educationFirstForm.get('applicant_educations') as FormArray;
// }


addEducationItems(){
  this.t2.push(

    // this.educationSecondForm
    this.formBuilder.group({
      institution_level: ['',Validators.required],
      institution_name: ['',Validators.required],
      enrolled_year: ['',Validators.required],
      graduated_year: ['',Validators.required],
      certification: ['',Validators.required],
      gpa: ['',Validators.required],

    })
  )

}


removeEducationItems(i: number){
  this.t2.removeAt(i);
}


onFormInitEducationFirstForm(){
  this.educationFirstForm = this.formBuilder.group({
    highest_level_of_education: ['',Validators.required],
    course_programme: ['',Validators.required],
    enrollment_status: ['',Validators.required],
    // resume: ['',Validators.required],
    // cover_letter: ['',Validators.required],
    // transcripts: ['',Validators.required],

    // secondForm: new FormArray([])
    applicant_educations: this.formBuilder.array([]),
})

}

educationSecondForm = this.formBuilder.group({
  institution_level: ['',Validators.required],
  institution_name: ['',Validators.required],
  enrolled_year: ['',Validators.required],
  graduated_year: ['',Validators.required],
  certification: ['',Validators.required],
  gpa: ['',Validators.required],

});

onFormInitEducationSecondForm(){
  this.educationSecondForm = this.formBuilder.group({
    institution_level: ['',Validators.required],
    institution_name: ['',Validators.required],
    enrolled_year: ['',Validators.required],
    graduated_year: ['',Validators.required],
    certification: ['',Validators.required],
    gpa: ['',Validators.required],
})

}


// onFileSelected(event: any){
//   console.log(event);
// }


// Experience

experienceEmptyForm = this.formBuilder.group({
  application_experiences: this.formBuilder.array([])
})

get f() { return this.experienceEmptyForm.controls; }
get t() { return this.f.application_experiences as FormArray; }

// get application_experiences(){
//   return this.experienceEmptyForm.get('application_experiences') as FormArray;
// }

addExperienceItems(){
  this.t.push(
    // this.experienceForm
    this.formBuilder.group({
      company_name:['',Validators.required],
      work_position:['',Validators.required],
      years_of_experience:['',Validators.required],
      referee_email:['',Validators.required],
      referee_name:['',Validators.required],
      referee_phone:['',Validators.required],

    })
    );
}

removeExperienceItems(i:number){
  this.t.removeAt(i);
}

onInitexperienceEmptyForm(){
  this.experienceEmptyForm = this.formBuilder.group({
    application_experiences: this.formBuilder.array([])
  })

}

experienceForm = this.formBuilder.group({
  company_name:['',Validators.required],
  work_position:['',Validators.required],
  years_of_experience:['',Validators.required],
  referee_email:['',Validators.required],
  referee_name:['',Validators.required],
  referee_phone:['',Validators.required],

})

onExperienceInit(){
  this.experienceForm = this.formBuilder.group({
    company_name:['',Validators.required],
    work_position:['',Validators.required],
    years_of_experience:['',Validators.required],
    referee_email:['',Validators.required],
    referee_name:['',Validators.required],
    referee_phone:['',Validators.required],

  })

}



// stepper validation


// sumbit data


onSubmit(){
  console.log("call onsubmit function")


  if(
    console.log("begin validate"),
    this.personalInfoForm.valid &&
    this.homeForm.valid &&
    this.contactForm.valid &&
    this.educationFirstForm.valid &&
    // this.educationSecondForm.valid &&
    this.experienceEmptyForm.valid

  ){
    console.log("end validate")

    console.log("Inside the condition")


    const formGroupData = Object.assign(
      {},
      this.personalInfoForm.value,
      this.homeForm.value,
      this.contactForm.value,

      this.educationFirstForm.value,
      this.educationSecondForm.value,
      this.experienceEmptyForm.value,
    );

    console.log("this is the form values",formGroupData);

    this.service.createApplicant(formGroupData).subscribe(
      (response) =>{
          alert("created successfully");
      },
      (error: HttpErrorResponse)=>{
        alert(error.message);
      }
    );


  }else{
    console.log("invalid values")
    console.log(this.personalInfoForm.value);
    console.log(this.homeForm.value);
    console.log(this.contactForm.value);
    console.log(this.educationFirstForm.value);
    console.log(this.educationSecondForm.value);
    console.log(this.experienceForm.value);

  }


}

onRead(){


}


}
