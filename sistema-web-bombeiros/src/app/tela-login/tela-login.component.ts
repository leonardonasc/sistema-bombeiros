import { AuthService } from './../auth/auth.service';
import { Component, Inject, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import JwtRequest from './../models/JwtRequest';

@Component({
  selector: 'app-tela-login',
  templateUrl: './tela-login.component.html',
  styleUrls: ['./tela-login.component.scss'],
})
export class TelaLoginComponent implements OnInit {
  constructor(private router: Router, private autenticacao: AuthService) {}

  ngOnInit(): void {}

  usuario: string = '';
  senha: string = '';

  async entrar() {
    if (this.usuario == "" || this.senha == "") {
      alert("Preencha usuário e senha!");
    } else {
      await this.autenticacao.createToken(new JwtRequest(this.usuario, this.senha)).then((value) => {
        console.log(value);
        if (this.autenticacao.isLogged()) {
          this.router.navigate(['/home']);
        }
        }).catch(e => alert("Usuário ou senha incorreta!"));
    }

  }
}
