import { Morador } from './../models/morador';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MoradoresService {

  constructor(private http: HttpClient) { }

  create(morador: Morador) {}
  read(id: number) {}
  update(morador: Morador) {}
  delete(id: number) {}
  list() {}
}
