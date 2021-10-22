import { UsuariosService } from './../services/usuarios.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { PageEvent, MatPaginator } from '@angular/material/paginator';
// import {MatPaginator} from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { nomeCompleto } from '../common/validators';

interface Perfil {
  value: string;
  viewValue: string;
}

export interface CadastroUsuarios {
  nome: string;
  matricula: number;
  nomeDeGuerra: string;
  email: string;
  perfilAcesso: string;
}

@Component({
  selector: 'app-tela-usuario',
  templateUrl: './tela-usuario.component.html',
  styleUrls: ['./tela-usuario.component.scss'],
})
export class TelaUsuarioComponent implements OnInit {
  constructor(private usuariosService: UsuariosService) {}

  displayedColumns: string[] = [
    'nome',
    'matricula',
    'nomeDeGuerra',
    'email',
    'perfilAcesso',
  ];
  usuarios: any;
  dataSource = new MatTableDataSource([]);

  formGroup = new FormGroup({
    nome: new FormControl('', [Validators.required, nomeCompleto()]),
    matricula: new FormControl('', [Validators.required]),
    nomeDeGuerra: new FormControl(''),
    senha: new FormControl('', [Validators.minLength(6), Validators.required]),
    confirmacaoSenha: new FormControl('', [
      Validators.minLength(6),
      Validators.required,
    ]),
    email: new FormControl('', [Validators.required, Validators.email]),
    perfilAcesso: new FormControl('', [Validators.required]),
  });

  async cadastrar() {
    if (this.formGroup.value.senha != this.formGroup.value.confirmacaoSenha) {
      alert('As senhas não coincidem!');
    } else if (
      this.formGroup.value.senha == '' &&
      this.formGroup.value.confirmacaoSenha == ''
    ) {
      alert('Os campos de senha devem ser preenchidos.');
    } else if (this.formGroup.valid) {
      await this.usuariosService.create(this.formGroup.value);
      alert('Usuário cadastrado com sucesso.');
      console.log(this.formGroup.value);
      this.formGroup.reset();
    }
  }

  carregarNaTela() {}

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  hide = true;

  ngOnInit() {
    this.getUsuarios();
  }

  async getUsuarios() {
    this.usuarios = await this.usuariosService.list();
    this.dataSource = new MatTableDataSource(this.usuarios);
    // console.log(this.usuarios)
  }

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }

  length = 500;
  pageSize = 4;
  pageIndex = 0;
  showFirstLastButtons = true;

  handlePageEvent(event: PageEvent) {
    this.length = event.length;
    this.pageSize = event.pageSize;
    this.pageIndex = event.pageIndex;
  }

  perfis: Perfil[] = [
    { value: 'admin-0', viewValue: 'Administrador' },
    { value: 'cobom-1', viewValue: 'Cobom' },
    { value: 'monitoramento-2', viewValue: 'Monitoramento' },
  ];
}
