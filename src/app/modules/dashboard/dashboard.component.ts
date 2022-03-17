import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { ActivatedRoute } from '@angular/router';
import { MyDetailsService } from '../my-details/my-details.service';
import { DashboardService } from './dashboard.service';

export interface Vacancy{
  vacancy_name:any
  department:any
  deadline_date:any
}

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})



export class DashboardComponent implements OnInit {

  displayedColumns: string[] = ['vacancy_name','department', 'deadline_date'];
  dataSource !: MatTableDataSource<Vacancy>;

  @ViewChild(MatPaginator) paginator !: MatPaginator;
  @ViewChild(MatSort) sort !: MatSort;
  vacancyArray: any;
  departmentArray: any;
  vacancy_name: any;
  dateArray: any;

  constructor(
    private service : MyDetailsService,
    private actRoute: ActivatedRoute,

    ) { }

  ngOnInit(): void {
    this.onRead();
  }

  // onGetAllDetails(){
  //   this.api_service.getAllUsers().subscribe({
  //     next:(response)=>{
  //       this.dataSource = new MatTableDataSource(response);
  //       this.dataSource.paginator = this.paginator;
  //       this.dataSource.sort = this.sort
  //     },error:(err)=>{
  //       alert("error while fetching the records!")
  //     }
  //   })
  // }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }



  onRead(){
    // const id = this.actRoute.snapshot.paramMap.get('id');
    return this.service.getVacancy().subscribe(
      data=>{

        this.dataSource = new MatTableDataSource(data);
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort

        // this.vacancyArray = data.vacancy_name;
        // this.departmentArray = data.department;
        // this.dateArray = data.deadline_date

        // const obj = Object.assign(
        //   this.vacancyArray.value,
        //   this.departmentArray.value,
        //   this.dateArray.value
        // );

        // console.log(obj)
        // this.dataSource = new MatTableDataSource(obj);
        // this.dataSource.paginator = this.paginator;
        // this.dataSource.sort = this.sort



        console.log(data)

      }
    )


    // this.dataSource1 = new MatTableDataSource(this.educationArray);
    // this.dataSource1.paginator = this.paginator;
    // this.dataSource1.sort = this.sort
  }

}

