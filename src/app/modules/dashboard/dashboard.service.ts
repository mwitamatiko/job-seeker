import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class DashboardService {

  private api_server_url = environment.api_url;

  constructor(private http: HttpClient) { }



  // public getAllUsers() : Observable<any>{
  //   return this.http.get<Dashboard[]>(`${this.api_server_url}/job-listing/jobs`);
  // }


}
