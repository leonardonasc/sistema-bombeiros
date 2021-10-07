import { Extintor } from './../models/extintor';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ExtintoresService {

  constructor(private http: HttpClient) { }

  create(extintor: Extintor) {}
  read(id: number) {}
  update(extintor: Extintor) {}
  delete(id: number) {}
  list() {}
}
