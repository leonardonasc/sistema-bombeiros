import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { PageEvent, MatPaginator } from '@angular/material/paginator';
// import {MatPaginator} from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { nomeCompleto } from '../common/validators';

interface Tipo {
  value: string;
  viewValue: string;
}

export interface CadastroMoradores {
  endereco: string;
  nome: string;
  telefone: number;
  numMoradores: number;
  tipoEdificacao: string;
  temBotijao: string;
  qtdBotijao: number;
}

const ELEMENT_DATA: CadastroMoradores[] = [
  {nome: 'Fulano', endereco: 'Rua Qualquer, 32', telefone: 5548991919199, numMoradores: 4, tipoEdificacao: 'Residencial', temBotijao: 'Sim', qtdBotijao: 1},
];


@Component({
  selector: 'app-tela-cadastro',
  templateUrl: './tela-cadastro.component.html',
  styleUrls: ['./tela-cadastro.component.scss']
})
export class TelaCadastroComponent implements OnInit {
  displayedColumns: string[] = ['nome', 'endereco', 'telefone', 'numMoradores', 'tipoEdificacao', 'temBotijao', 'qtdBotijao'];
  // dataSource = ELEMENT_DATA;
  dataSource = new MatTableDataSource<CadastroMoradores>(ELEMENT_DATA);
  clickedRows = new Set<CadastroMoradores>();
  serializedDate = new FormControl((new Date()).toISOString());

  constructor() { }

  ngOnInit(): void {
  }

  formGroup = new FormGroup({
    nomeCompleto: new FormControl('', [Validators.required, nomeCompleto()]),
    endereco: new FormControl('', [Validators.required]),
    telefone: new FormControl('', [Validators.required]),
    numMoradores: new FormControl('', [Validators.required]),
    tipoEdificacao: new FormControl('', [Validators.required]),
    objeto: new FormControl('', [Validators.required]),
    validade: new FormControl('', [Validators.required]),
    temBotijao: new FormControl('', [Validators.required]),
    qtdBotijao: new FormControl(''),
    marcaMangueira: new FormControl(''),
    modeloMangueira: new FormControl(''),
    validadeMangueira: new FormControl(''),
    marcaValvula: new FormControl(''),
    modeloValvula: new FormControl(''),
    validadeValvula: new FormControl(''),
  });

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

  i!: number;

  tipos: Tipo[] = [
    {value: 'comercial-0', viewValue: 'Comercial'},
    {value: 'residencial-1', viewValue: 'Residencial'},
  ];

  botijoes: Tipo[] = [
    {value: 'nao-0', viewValue: 'Não'},
    {value: 'sim-1', viewValue: 'Sim'},
  ];

  objetos: Tipo[] = [
    {value: 'mangueira', viewValue: 'Mangueira'},
    {value: 'valvula', viewValue: 'Válvula'},
  ];

}
