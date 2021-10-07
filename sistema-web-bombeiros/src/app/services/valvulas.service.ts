import { Valvula } from './../models/valvula';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ValvulasService {

  constructor(private http: HttpClient) { }

  create(valvula: Valvula) {}
  read(id: number) {}
  update(valvula: Valvula) {}
  delete(id: number) {}
  list() {}
}
