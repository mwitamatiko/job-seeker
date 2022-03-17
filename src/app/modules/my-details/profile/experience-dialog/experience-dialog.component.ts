import { Experience } from '../profile.component';
import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ActivatedRoute } from '@angular/router';
import { MyDetailsService } from '../../my-details.service';



@Component({
  selector: 'app-experience-dialog',
  templateUrl: './experience-dialog.component.html',
  styleUrls: ['./experience-dialog.component.css']
})
export class ExperienceDialogComponent implements OnInit {



  experienceArray: any;

  constructor(
    private service : MyDetailsService,
    private actRoute: ActivatedRoute,
    private dialogRef: MatDialogRef<ExperienceDialogComponent>,
    private formBuilder: FormBuilder,
    @Inject(MAT_DIALOG_DATA) public editData:any,
    // private actRoute: ActivatedRoute,
    // private dialog: MatDialog,
  ) { }


  experienceForm4 = this.formBuilder.group({
    company_name:['',Validators.required],
    work_position:['',Validators.required],
    years_of_experience:['',Validators.required],
    referee_email:['',Validators.required],
    referee_name:['',Validators.required],
    referee_phone:['',Validators.required],

  })

  ngOnInit(): void {
    // console.log(this.editData);
    if(this.editData){
      // this.experienceForm4.controls['company_name'],
      // this.experienceForm4.controls['work_position'],
      // this.experienceForm4.controls['years_of_experience'],
      // this.experienceForm4.controls['referee_email'],
      // this.experienceForm4.controls['referee_name'],
      // this.experienceForm4.controls['referee_phone'],


    this.experienceForm4 = this.formBuilder.group({
    company_name:[this.editData.company_name],
    work_position:[this.editData.work_position],
    years_of_experience:[this.editData.years_of_experience],
    referee_email:[this.editData.referee_email],
    referee_name:[this.editData.referee_name],
    referee_phone:[this.editData.referee_phone],

  })

    }
  }



  onUpdateExperience(){
    let id = this.editData.id;
    console.log("experience data ",this.experienceForm4.value)
    this.service.putDialog(id,this.experienceForm4.value).subscribe(
      (response) =>{

        console.log(response)
        alert("updated successfully")
        this.dialogRef.close()
        // onRead()

      },(error)=>{
        alert("update failed")
        this.dialogRef.close()
      }
    )
  }






}
