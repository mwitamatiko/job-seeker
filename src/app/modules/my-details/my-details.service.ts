
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { catchError, map, Observable, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MyDetailsService {

  headers = new HttpHeaders().set('Content-Type', 'application/json');
  private api_server_url = environment.api_url;

  constructor(private http: HttpClient) { }

  /**
   *
   * @param data create a new applicant
   * @returns
   */

  public createApplicant(data: any): Observable<any>{

    console.log("service data",data);
    let apiUrl = `${this.api_server_url}/api/v1/applicant/add`;

    return this.http.post(apiUrl,data,{headers: this.headers, withCredentials: false}).pipe(
      map(response=>{
        return response || {}
      }),
      catchError(this.errorMgmt)
    );

  }

  // updateApplication(id: string | null, data: any): Observable<any> {
  //   let API_URL = `${this.baseURL}/update/${id}`;
  //   return this.http.put(API_URL, data, {headers: this.headers, withCredentials: false})
  //     .pipe(
  //       catchError(this.errorMgmt)
  //     )
  // }


  /**
   * get an applicant by id
   * @param id
   * @returns
   */
  public getApplicantById(id: any): Observable<any>{
    console.log("service data",id);
    let apiUrl = `${this.api_server_url}/api/v1/applicant/${id}`;
    return this.http.get(apiUrl).pipe(
      map(response=>{
        return response || {}
      }),
      catchError(this.errorMgmt)
    );
  }



public getVacancy(): Observable<any>{

  let apiUrl = `http://192.168.100.155:8084/vacancy/all`;
  return this.http.get(apiUrl).pipe(
    map(response=>{
      return response || {}
    }),
    catchError(this.errorMgmt)
  );

}

public getMyApplications(id:any): Observable<any>{
  console.log("service data",id);
  let apiUrl = `${this.api_server_url}//api/v1/myApplications/${id}`;

  return this.http.get(apiUrl,id).pipe(
    map(response=>{
      return response || {}
    }),
    catchError(this.errorMgmt)
  );

}

  public updateAplicantbyId(id:any,data:any): Observable<any>{
     console.log("service data",id);
     console.log("data ",data)
    let apiUrl = `${this.api_server_url}/api/v1/applicant/update/applicant/${id}`;
    return this.http.put(apiUrl,data,{headers: this.headers, withCredentials: false}).pipe(
      map(response=>{
        return response || {}
      }),
      catchError(this.errorMgmt)
    );
  }


  public putDialog(id:any,data:any): Observable<any>{
    console.log("service data",id);
    console.log("data ",data)
   let apiUrl = `${this.api_server_url}/api/v1/experience/update/${id}`;
   return this.http.put(apiUrl,data).pipe(
     map(response=>{
       return response || {}
     }),
     catchError(this.errorMgmt)
   );
 }

 public putEducationDialog(id:any,data:any): Observable<any>{

  console.log("service data",id);
    console.log("data ",data)
   let apiUrl = `${this.api_server_url}/api/v1/education/update/${id}`;
   return this.http.put(apiUrl,data).pipe(
     map(response=>{
       return response || {}
     }),
     catchError(this.errorMgmt)
   );

 }



  /**
   *
   * @param data create experience
   * @returns
   */
  public createExperience(data: any): Observable<any>{
    console.log("service data",data);
    let apiUrl = `${this.api_server_url}/api/v1/experience/add`;
    return this.http.post(apiUrl,data).pipe(
      map(response=>{
        return response || {}
      }),
      catchError(this.errorMgmt)
    );
  }


  public getExperienceById(id: any): Observable<any>{
    console.log("service data",id);
    let apiUrl = `${this.api_server_url}/api/v1/experience/${id}`;
    return this.http.get(apiUrl).pipe(
      map(response=>{
        return response || {}
      }),
      catchError(this.errorMgmt)
    );
  }

  /**
   * create education
   * @param data
   * @returns
   */
  public createEducation(data: any): Observable<any>{
    console.log("service data",data);
    let apiUrl = `${this.api_server_url}/api/v1/education/add`;
    return this.http.post(apiUrl,data).pipe(
      map(response=>{
        return response || {}
      }),
      catchError(this.errorMgmt)
    );
  }

  public getEducationById(id: any): Observable<any>{
    console.log("service data",id);
    let apiUrl = `${this.api_server_url}/api/v1/education/${id}`;
    return this.http.get(apiUrl).pipe(
      map(response=>{
        return response || {}
      }),
      catchError(this.errorMgmt)
    );
  }


  public deleteEducation(id:any): Observable<any>{
    console.log("data id to delete education",id)
    let apiUrl = `${this.api_server_url}/api/v1/applicant/delete/education/${id}`;
    return this.http.get(apiUrl).pipe(
      map(response =>{
        return response || {}
      }),
      catchError(this.errorMgmt)
    )
  }

  public deleteExperience(id:any): Observable<any>{
    console.log("data id to delete experience",id)
    let apiUrl = `${this.api_server_url}/api/v1/applicant/delete/experience/${id}`;
    return this.http.get(apiUrl).pipe(
      map(response =>{
        return response || {}
      }),
      catchError(this.errorMgmt)
    )
  }





  // checkOverdraft(params: any): Observable<any> {
  //   console.log("service", params)
  //   let API_URL = `${this.api_server_url}/check/by/InterestTableCode`;
  //   return this.http.post(API_URL, {}, {params:params, headers: this.headers, withCredentials: false }).pipe(map(res => {
  //       return res || {}
  //     }),
  //     catchError(this.errorMgmt)
  //   )
  // }

  // Error handling
  errorMgmt(error: HttpErrorResponse) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      // Get client-side error
      errorMessage = error.error.message;
    } else {
      // Get server-side error
      errorMessage = `${error.error.message}`;
    }
    return throwError(errorMessage);
  }
}


