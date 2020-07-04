import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { EmployeeService } from '../employee.service';
import { Employee } from '../employee';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.scss']
})
export class ContactComponent implements OnInit {

  employee: Employee;
  id;
  subscriber;
  messageForm: FormGroup;
  submitted = false;
  success = false;

  constructor(private formBuilder: FormBuilder, private activatedRoute: ActivatedRoute,
              private router: Router, private employeeService: EmployeeService) {
     this.messageForm = this.formBuilder.group({
       bonus: ['', Validators.required]
     })
  }

  ngOnInit() {
    this.subscriber = this.activatedRoute.paramMap.subscribe(params => {
        this.id = params.get('id');
        this.employeeService.getById(+this.id).subscribe(result => {
           this.employee = result.body;
           console.log(this.employee);
        });
    });
  }

  onSubmit(){
    this.submitted = true;
    if(this.messageForm.invalid){
      return;
    }

    this.employee.commission = +this.messageForm.controls.bonus.value;
    this.success = true;
    this.employeeService.updateEmployee(this.employee).subscribe(result => {
      this.router.navigate(['/']);
    });
  }

  onBack(): void {
    this.router.navigate(['/']);
  }

   ngOnDestroy() {
     this.subscriber.unsubscribe();
   }
}
