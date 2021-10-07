import { Hidrante } from './../models/hidrante';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class HidrantesService {

  constructor(private http: HttpClient) { }

  create(hidrante: Hidrante) {}
  read(id: number) {}
  update(hidrante: Hidrante) {}
  delete(id: number) {}
  list() {}
}
