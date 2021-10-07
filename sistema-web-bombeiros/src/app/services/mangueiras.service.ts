import { Mangueira } from './../models/mangueira';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MangueirasService {

  constructor(private http: HttpClient) { }

  create(mangueira: Mangueira) {}
  read(id: number) {}
  update(mangueira: Mangueira) {}
  delete(id: number) {}
  list() {}
}
