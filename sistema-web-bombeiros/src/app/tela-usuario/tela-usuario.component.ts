import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { PageEvent, MatPaginator } from '@angular/material/paginator';
// import {MatPaginator} from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';

interface Perfil {
  value: string;
  viewValue: string;
}

export interface CadastroUsuarios {
  nome: string;
  matricula: number;
  nomeDeGuerra: string;
  perfilAcesso: string;

}

const ELEMENT_DATA: CadastroUsuarios[] = [
  {nome: 'Fulano', matricula: 99999, nomeDeGuerra: 'Sargento Fulano', perfilAcesso: 'Monitoramento'},
];

@Component({
  selector: 'app-tela-usuario',
  templateUrl: './tela-usuario.component.html',
  styleUrls: ['./tela-usuario.component.scss']
})
export class TelaUsuarioComponent implements OnInit {
  displayedColumns: string[] = ['nome', 'matricula', 'nomeDeGuerra', 'perfilAcesso'];
  // dataSource = ELEMENT_DATA;
  dataSource = new MatTableDataSource<CadastroUsuarios>(ELEMENT_DATA);
  clickedRows = new Set<CadastroUsuarios>();

  hide = true;

  perfis: Perfil[] = [
    {value: 'admin-0', viewValue: 'Administrador'},
    {value: 'cobom-1', viewValue: 'Cobom'},
    {value: 'monitoramento-2', viewValue: 'Monitoramento'}
  ];

  constructor() { }

  ngOnInit(): void {
  }

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }

  length = 500;
  pageSize = 4;
  pageIndex = 0;
  // pageSizeOptions = [3,4,5];
  showFirstLastButtons = true;

  handlePageEvent(event: PageEvent) {
    this.length = event.length;
    this.pageSize = event.pageSize;
    this.pageIndex = event.pageIndex;
  }

}
