import { Usuario } from './../models/usuario';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UsuariosService {

  constructor(private http: HttpClient) { }

  create(usuario: Usuario) {}
  read(id: number) {}
  update(usuario: Usuario) {}
  delete(id: number) {}
  list() {}
}
