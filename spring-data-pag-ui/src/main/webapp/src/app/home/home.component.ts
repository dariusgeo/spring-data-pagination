import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { EmployeeService } from '../employee.service';
import { Employee } from '../employee';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  public employees: Employee[] = [];
  public requestParams: Object;
  public page: number;
  public first: string = "";
  public prev: string = "";
  public next: string = "";
  public last: string = "";


  constructor(public employeeService: EmployeeService) {
    this.page = 0;
  }

  ngOnInit() {
    this.employeeService.getFirstPage().subscribe(data => {
      this.parseLinkHeader(data.headers.get('Link'));
      for(var i = 0 ; i < data.body.length; i++){
        this.employees.push(data.body[i]);
      }
      console.log(this.employees);
    })
  }

  onScroll() {
    console.log('scrolled!!');
    this.employeeService.getNextPage(++this.page).subscribe(data => {
     this.parseLinkHeader(data.headers.get('Link'));
     if (data.body != null) {
        for(var i = 0 ; i < data.body.length; i++){
          this.employees.push(data.body[i]);
        }
     }
      console.log(this.employees);
    });
  }

  parseLinkHeader(header) {
      if (header.length == 0) {
        return ;
      }

      let parts = header.split(',');
      var links = {};
      parts.forEach( p => {
        let section = p.split(';');
        var url = section[0].replace(/<(.*)>/, '$1').trim();
        var name = section[1].replace(/rel="(.*)"/, '$1').trim();
        links[name] = url;
       });

     this.first  = links["first"];
     this.last   = links["last"];
     this.prev   = links["prev"];
     this.next   = links["next"];
    }

}
