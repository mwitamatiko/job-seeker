import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ActivatedRoute } from '@angular/router';
import { MyDetailsService } from '../../my-details.service';

@Component({
  selector: 'app-education-dialog',
  templateUrl: './education-dialog.component.html',
  styleUrls: ['./education-dialog.component.css']
})
export class EducationDialogComponent implements OnInit {

  constructor(
    @Inject(MAT_DIALOG_DATA) public editData:any,
    private formBuilder: FormBuilder,
    private service : MyDetailsService,
    private actRoute: ActivatedRoute,
    private dialogRef: MatDialogRef<EducationDialogComponent>,

  ) { }

  educationForm4 = this.formBuilder.group({
    institution_level: ['',Validators.required],
    institution_name: ['',Validators.required],
    enrolled_year: ['',Validators.required],
    graduated_year: ['',Validators.required],
    certification: ['',Validators.required],
    gpa: ['',Validators.required],
})

  ngOnInit(): void {
    // this.onReadEducation();
    // console.log(this.editData)
    if(this.editData){
      // this.educationForm3.controls['institution_level'].setValue(this.editData.institution_level);
      // this.educationForm3.controls['institution_name'].setValue(this.editData.institution_name);
      // this.educationForm3.controls['enrolled_year'].setValue(this.editData.enrolled_year);
      // this.educationForm3.controls['graduated_year'].setValue(this.editData.graduated_year);
      // this.educationForm3.controls['certification'].setValue(this.editData.certification);
      // this.educationForm3.controls['gpa'].setValue(this.editData.gpa);

      this.educationForm4 = this.formBuilder.group({
        institution_level: [this.editData.institution_level],
        institution_name: [this.editData.institution_name],
        enrolled_year: [this.editData.enrolled_year],
        graduated_year: [this.editData.graduated_year],
        certification: [this.editData.certificationd],
        gpa: [this.editData.gpa],
    })
  }


  }


  onUpdateEducation(){
    let id = this.editData.id;
    console.log("experience data ",this.educationForm4.value)

    this.service.putEducationDialog(id,this.educationForm4.value).subscribe(
      (response) =>{

        console.log(response)
        alert("updated successfully")
        this.dialogRef.close()


      },(error)=>{
        alert("update failed")
        this.dialogRef.close()
      }
    )
  }

}



