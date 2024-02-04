import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Observable, catchError, throwError } from 'rxjs';
import { ShoppingItem } from '../model/shopping-item';

const url: string = 'http://backend:8080/list';
// const url: string = 'http://3.79.137.183:8080/list';

@Injectable({
  providedIn: 'root'
})

export class ShoppingService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<ShoppingItem[]> {
    return this.http.get<ShoppingItem[]>(url, { responseType: 'json' }).pipe(
      catchError(this.handleError)
    );;
  }

  get(id: any): Observable<ShoppingItem> {
    return this.http.get<ShoppingItem>(`${url}/${id}`).pipe(
      catchError(this.handleError)
    );;
  }

  create(data: any): Observable<any> {
    return this.http.post(url, data).pipe(
      catchError(this.handleError)
    );;
  }

  delete(id: any): Observable<any> {
    return this.http.delete(`${url}/${id}`).pipe(
      catchError(this.handleError)
    );;
  }

  private handleError(error: HttpErrorResponse) {
    if (error.status === 0) {
      console.error('An error occurred:', error.error);
    } else {
      console.error(
        `Backend returned code ${error.status}, body was: `, error.error);
    }
    return throwError(() => new Error('Something bad happened; please try again later.'));
  }
}


