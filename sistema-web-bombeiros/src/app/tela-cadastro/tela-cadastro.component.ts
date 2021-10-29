import { MoradoresService } from './../services/moradores.service';
import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { PageEvent, MatPaginator } from '@angular/material/paginator';
// import {MatPaginator} from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { nomeCompleto } from '../common/validators';
import { ViacepService } from '../services/viacep.service';

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

@Component({
  selector: 'app-tela-cadastro',
  templateUrl: './tela-cadastro.component.html',
  styleUrls: ['./tela-cadastro.component.scss'],
})
export class TelaCadastroComponent implements OnInit {
  displayedColumns: string[] = [
    'nome',
    'endereco',
    'telefone1',
    'numMoradores',
    'tipoEdificacao',
    'temBotijao',
    'qtdBotijao',
  ];
  clickedRows = new Set<CadastroMoradores>();
  serializedDate = new FormControl(new Date().toISOString());
  cep: string = '';
  clicado: boolean = false;
  moradores: any;
  dataSource = new MatTableDataSource([]);
  editar: boolean = false;

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  constructor(
    private cepService: ViacepService,
    private moradoresService: MoradoresService
  ) {}

  ngOnInit() {
    this.getMoradores();
  }

  formGroup = new FormGroup({
    id: new FormControl(),
    nome: new FormControl('', [Validators.required, nomeCompleto()]),
    cep: new FormControl('', [Validators.required]),
    endereco: new FormControl('', [Validators.required]),
    numEndereco: new FormControl('', [Validators.required]),
    bairro: new FormControl('', [Validators.required]),
    cidade: new FormControl('', [Validators.required]),
    telefone1: new FormControl('', [Validators.required]),
    telefone2: new FormControl(''),
    cpf: new FormControl('', [
      Validators.required,
      Validators.minLength(11),
      Validators.maxLength(11),
    ]),
    email: new FormControl('', [Validators.required, Validators.email]),
    numMoradores: new FormControl('', [Validators.required]),
    tipoEdificacao: new FormControl('', [Validators.required]),
    temBotijao: new FormControl('', [Validators.required]),
    qtdBotijao: new FormControl(''),
    tamanhoMangueira: new FormControl('', [Validators.required]),
    modeloMangueira: new FormControl('', [Validators.required]),
    validadeMangueira: new FormControl('', [Validators.required]),
    validadeValvula: new FormControl('', [Validators.required]),
    validadeHidrante: new FormControl('', [Validators.required]),
    numeroPatrimonio: new FormControl('', [Validators.required]),
    ultimoTeste: new FormControl('', [Validators.required]),
    statusAtividade: new FormControl('', [Validators.required]),
    validadeExtintor: new FormControl('', [Validators.required]),
    modeloExtintor: new FormControl('', [Validators.required]),
    seloInmetro: new FormControl('', [Validators.required]),
    pesoExtintor: new FormControl('', [Validators.required]),
    anoExpecao: new FormControl('', [
      Validators.required,
      Validators.minLength(4),
    ]),
  });

  async getEnderecoPeloCep() {
    const endereco = await this.cepService.read(this.formGroup.value.cep);
    this.formGroup.controls.endereco.setValue(endereco.logradouro);
    this.formGroup.controls.bairro.setValue(endereco.bairro);
    this.formGroup.controls.cidade.setValue(endereco.localidade);
  }

  async getMoradores() {
    this.moradores = await this.moradoresService.list();
    this.dataSource = new MatTableDataSource(this.moradores);
    // console.log(this.moradores);
  }

  async cadastrar() {
    if (this.formGroup.valid) {
      alert('Usuário cadastrado com sucesso.');
      await this.moradoresService.create(this.formGroup.value);
      console.log(this.formGroup.value);
    }
  }

  async salvarCadastro() {
    await this.moradoresService.update(this.formGroup.value);
    this.editar = false;
  }

  async deletar() {
    if (confirm("Deseja realmente excluir o cadastro?")) {
      await this.moradoresService.delete(this.formGroup.controls.id.value);
      this.editar = false;
    }
  }

  carregaNaTela(row: any) {
    console.log(row)
    this.editar = true;
    this.formGroup.controls.id.setValue(row.id);
    this.formGroup.controls.nome.setValue(row.nome);
    this.formGroup.controls.cep.setValue(row.cep);
    this.formGroup.controls.endereco.setValue(row.endereco);
    this.formGroup.controls.numEndereco.setValue(row.numEndereco);
    this.formGroup.controls.bairro.setValue(row.bairro);
    this.formGroup.controls.cidade.setValue(row.cidade);
    this.formGroup.controls.telefone1.setValue(row.telefone1);
    this.formGroup.controls.telefone2.setValue(row.telefone2);
    this.formGroup.controls.cpf.setValue(row.cpf);
    this.formGroup.controls.email.setValue(row.email);
    this.formGroup.controls.numMoradores.setValue(row.numMoradores);
    this.formGroup.controls.tipoEdificacao.setValue(row.tipoEdificacao);
    this.formGroup.controls.temBotijao.setValue(row.temBotijao);
    this.formGroup.controls.qtdBotijao.setValue(row.qtdBotijao);
    this.formGroup.controls.tamanhoMangueira.setValue(row.tamanhoMangueira);
    this.formGroup.controls.modeloMangueira.setValue(row.modeloMangueira);
    this.formGroup.controls.validadeMangueira.setValue(row.validadeMangueira);
    this.formGroup.controls.validadeValvula.setValue(row.validadeValvula);
    this.formGroup.controls.validadeHidrante.setValue(row.validadeHidrante);
    this.formGroup.controls.numeroPatrimonio.setValue(row.numeroPatrimonio);
    this.formGroup.controls.ultimoTeste.setValue(row.ultimoTeste);
    this.formGroup.controls.statusAtividade.setValue(row.statusAtividade);
    this.formGroup.controls.validadeExtintor.setValue(row.validadeExtintor);
    this.formGroup.controls.modeloExtintor.setValue(row.modeloExtintor);
    this.formGroup.controls.seloInmetro.setValue(row.seloInmetro);
    this.formGroup.controls.pesoExtintor.setValue(row.pesoExtintor);
    this.formGroup.controls.anoExpecao.setValue(row.anoExpecao);
  }

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  async ngAfterViewInit() {
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

  i!: number;

  tipos: Tipo[] = [
    { value: 'Comercial', viewValue: 'Comercial' },
    { value: 'Residencial', viewValue: 'Residencial' },
  ];

  botijoes: Tipo[] = [
    { value: 'Não', viewValue: 'Não' },
    { value: 'Sim', viewValue: 'Sim' },
  ];

  selosInmetro: Tipo[] = [
    { value: 'Não', viewValue: 'Não' },
    { value: 'Sim', viewValue: 'Sim' },
  ];

  modelosMangueira: Tipo[] = [
    { value: 'Mangueira Plástica', viewValue: 'Mangueira Plástica' },
    { value: 'Mangueira de Aço', viewValue: 'Mangueira de Aço' },
  ];

  modelosExtintor: Tipo[] = [
    { value: 'Água', viewValue: 'Água' },
    { value: 'Espuma Mecânica', viewValue: 'Espuma Mecânica' },
    {
      value: 'Dióxido de Carbono (CO2)',
      viewValue: 'Dióxido de Carbono (CO2)',
    },
    { value: 'Pó Químico ABC', viewValue: 'Pó Químico ABC' },
    { value: 'Pó Químico BC', viewValue: 'Pó Químico BC' },
    { value: 'Halogenados (Halon)', viewValue: 'Halogenados (Halon)' },
    { value: 'Classe D', viewValue: 'Classe D' },
    { value: 'Classe K', viewValue: 'Classe K' },
  ];
}
