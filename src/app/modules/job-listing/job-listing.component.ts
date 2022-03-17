import { FormBuilder } from '@angular/forms';
import { EducationDialogComponent } from '../my-details/profile/education-dialog/education-dialog.component';
import { ExperienceDialogComponent } from '../my-details/profile/experience-dialog/experience-dialog.component';
import { DialogComponent } from './dialog/dialog.component';
import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-job-listing',
  templateUrl: './job-listing.component.html',
  styleUrls: ['./job-listing.component.css']
})
export class JobListingComponent implements OnInit {

  paramsEmployeeData: any = [
    'Executive Position','Lead Position','Technical Engineer','Technical Assistant','Intermediate Position','Entry Level','Internship Level','Attachment Level'
  ]

  jobs =[
    {id:1,value:'Job Title'},
    {id:2,value:'Entry Level'},
    {id:3,value:'Deadline'},
  ]

  constructor(public dialog: MatDialog,
    private service: HttpClient,
    private formBuilder: FormBuilder,
    ) { }



  ngOnInit(): void {
    this.onInitJobGroup();

}

jobGroup = this.formBuilder.group({
  job: [''],
})

onInitJobGroup(){
  this.jobGroup = this.formBuilder.group({
    job:['']
  })
}
openDialog4() {
  this.dialog.open(DialogComponent,{

  });
}

// onRead(){
//   // const id = this.actRoute.snapshot.paramMap.get('id');
//   return this.service.getVacancy().subscribe(
//     data=>{

//       this.dataSource = new MatTableDataSource(data);
//       this.dataSource.paginator = this.paginator;
//       this.dataSource.sort = this.sort

//       // this.vacancyArray = data.vacancy_name;
//       // this.departmentArray = data.department;
//       // this.dateArray = data.deadline_date

//       // const obj = Object.assign(
//       //   this.vacancyArray.value,
//       //   this.departmentArray.value,
//       //   this.dateArray.value
//       // );

//       // console.log(obj)
//       // this.dataSource = new MatTableDataSource(obj);
//       // this.dataSource.paginator = this.paginator;
//       // this.dataSource.sort = this.sort



//       console.log(data)

//     }
//   )


  // this.dataSource1 = new MatTableDataSource(this.educationArray);
  // this.dataSource1.paginator = this.paginator;
  // this.dataSource1.sort = this.sort
// }

// }




}

