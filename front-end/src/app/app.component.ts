import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { ShoppingItem } from './model/shopping-item';
import { ShoppingService } from './service/shopping.service';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { faCircleXmark } from '@fortawesome/free-solid-svg-icons';
import { AddItemComponent } from './add-item/add-item.component';

@Component({
  selector: 'app-root',
  standalone: true,
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss',
  imports: [CommonModule, RouterOutlet, AddItemComponent, FontAwesomeModule]
})
export class AppComponent implements OnInit {
  title = 'Lista zakupów';
  faDelete = faCircleXmark;

  shoppingList?: ShoppingItem[];
  currentIndex = -1;

  constructor(private service: ShoppingService) { }

  ngOnInit(): void {
    this.shoppingList = this.showAllShoppingItems();
  }

  showAllShoppingItems(): any {
    this.service.getAll().subscribe({
      next: (data) => {
        this.shoppingList = data;
      },
      error: (e) => console.log(e)
    })
  }

  deleteShoppingItem(id: number) {
    this.service.delete(id).subscribe(res => {
      this.shoppingList = this.shoppingList?.filter(item => item.id !== id);
      console.log('Shopping Item removed successfully!');
    })
  }

}
