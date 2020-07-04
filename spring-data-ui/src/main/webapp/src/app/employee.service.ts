import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams, HttpErrorResponse } from '@angular/common/http';
import { Employee } from './employee';
import { retry, catchError, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  apiURL = 'http://localhost:9090/api/employees';

  constructor(private httpClient: HttpClient) { }

  public getFirstPage(){
      return this.httpClient.get<Employee[]>(`${this.apiURL}/all`, { observe: 'response'}).pipe(tap(result => {
        return result;
      }));
    }

  public getNextPage(page: number){
        return this.httpClient.get<Employee[]>(`${this.apiURL}/all?page=` + page + `&size=20`, { observe: 'response'}).pipe(tap(result => {
          return result;
        }));
   }

  public getById(id: number){
      return this.httpClient.get<Employee>(`${this.apiURL}/` + id, { observe: 'response'}).pipe(tap(result => {
        return result;
      }));
  }

  public createEmployee(employee: Employee){
    return this.httpClient.post(`${this.apiURL}`, employee);
  }

  public updateEmployee(employee: Employee){
    return this.httpClient.put<Employee>(`${this.apiURL}`,
                                         employee,
                                          {
                                            headers: {
                                              'Access-Control-Allow-Headers': '*',
                                              'Access-Control-Allow-Origin': '*'
                                            }
                                          });
  }

  public deleteEmployee(id: number){
    return this.httpClient.delete(`${this.apiURL}/${id}`);
  }
}
