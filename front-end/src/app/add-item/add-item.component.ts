import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ShoppingService } from '../service/shopping.service';
import { ShoppingItem } from '../model/shopping-item';
import { AppComponent } from '../app.component';

@Component({
  selector: 'app-add-item',
  standalone: true,
  imports: [ReactiveFormsModule, CommonModule],
  templateUrl: './add-item.component.html',
  styleUrl: './add-item.component.scss'
})
export class AddItemComponent implements OnInit {

  myForm!: FormGroup;
  units = ["OP", "SZT", "L", "KG"]
  item: ShoppingItem = {
    product: '',
    quantity: undefined,
    units: ''
  };

  constructor(private fb: FormBuilder, private service: ShoppingService, private mainComponent: AppComponent) { }

  ngOnInit(): void {
    this.myForm = this.fb.group({
      product: ['', Validators.required],
      quantity: [null, Validators.required],
      units: ['', Validators.required]
    });
  }

  addShoppingItem(): void {
    const data = {
      product: this.myForm.value.product,
      quantity: this.myForm.value.quantity,
      units: this.myForm.value.units
    }

    this.service.create(data)
      .subscribe({
        next: (res) => {
          this.mainComponent.ngOnInit();
        },
        error: (e) => console.log(e)
      });
  }

  onSubmit() {
    console.log(this.myForm.value)
    this.addShoppingItem();
  }

}
