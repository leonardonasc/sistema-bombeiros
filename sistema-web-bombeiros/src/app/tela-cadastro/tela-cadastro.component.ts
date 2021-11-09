import { ValvulasService } from './../services/valvulas.service';
import { MangueirasService } from './../services/mangueiras.service';
import { HidrantesService } from './../services/hidrantes.service';
import { ExtintoresService } from './../services/extintores.service';
import { EdificacoesService } from '../services/edificacoes.service';
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

export interface CadastroEdificacoes {
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
    'numeroMoradores',
    'tipoEdificacao',
    'temBotijao',
    'qtdBotijao',
  ];
  clickedRows = new Set<CadastroEdificacoes>();
  serializedDate = new FormControl(new Date().toISOString());
  cep: string = '';
  clicado: boolean = false;
  edificacoes: any;
  dataSource = new MatTableDataSource([]);
  editar: boolean = false;

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  constructor(
    private cepService: ViacepService,
    private edificacoesService: EdificacoesService,
    private extintoresService: ExtintoresService,
    private hidrantesService: HidrantesService,
    private mangueirasService: MangueirasService,
    private valvulasServies: ValvulasService
  ) {}

  ngOnInit() {
    this.getEdificacoes();
  }

  formGroup = new FormGroup({
    id: new FormControl(),
    nome: new FormControl('', [Validators.required, nomeCompleto()]),
    cep: new FormControl('', [Validators.required]),
    endereco: new FormControl('', [Validators.required]),
    numeroEndereco: new FormControl('', [Validators.required]),
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
    numeroMoradores: new FormControl('', [Validators.required]),
    tipoEdificacao: new FormControl('', [Validators.required]),
    temBotijao: new FormControl('', [Validators.required]),
    qtdBotijao: new FormControl(''),
  });

  formValvula = new FormGroup({
    id: new FormControl(),
    validadeValvula: new FormControl('', [Validators.required]),

  });

  formMangueira = new FormGroup({
    id: new FormControl(),
    modeloMangueira: new FormControl('', [Validators.required]),
    tamanhoMangueira: new FormControl('', [Validators.required]),
    validadeMangueira: new FormControl('', [Validators.required]),
  });

  formHidrante = new FormGroup({
    id: new FormControl(),
    validadeHidrante: new FormControl('', [Validators.required]),
    numeroPatrimonio: new FormControl('', [Validators.required]),
    ultimoTeste: new FormControl('', [Validators.required]),
    statusAtividade: new FormControl('', [Validators.required]),
  });

  formExtintor = new FormGroup({
    id: new FormControl(),
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

  async getEdificacoes() {
    this.edificacoes = await this.edificacoesService.list();
    this.dataSource = new MatTableDataSource(this.edificacoes);
    // console.log(this.edificacoes);
  }

  async cadastrar() {
    if (this.formGroup.valid) {
      // alert('Usuário cadastrado com sucesso.');
      const edificacao = await this.edificacoesService.create(this.formGroup.value);
      const extintor = this.formExtintor.value;
      const hidrante = this.formHidrante.value;
      const mangueira = this.formMangueira.value;
      const valvula = this.formValvula.value;
      extintor.edificacao = edificacao.id;
      hidrante.edificacao = edificacao.id;
      mangueira.edificacao = edificacao.id;
      valvula.edificacao = edificacao.id;
      console.log(extintor);
      const cons = await this.extintoresService.create(extintor);
      await this.hidrantesService.create(hidrante);
      await this.mangueirasService.create(mangueira);
      await this.valvulasServies.create(valvula);
    }
  }

  async salvarCadastro() {
    await this.edificacoesService.update(this.formGroup.value);
    this.editar = false;
  }

  async deletar() {
    if (confirm("Deseja realmente excluir o cadastro?")) {
      await this.edificacoesService.delete(this.formGroup.controls.id.value);
      this.editar = false;
    }
  }

  carregaNaTela(row: any) {
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
    this.formMangueira.controls.tamanhoMangueira.setValue(row.tamanhoMangueira);
    this.formMangueira.controls.modeloMangueira.setValue(row.modeloMangueira);
    this.formMangueira.controls.validadeMangueira.setValue(row.validadeMangueira);
    this.formValvula.controls.validadeValvula.setValue(row.validadeValvula);
    this.formHidrante.controls.validadeHidrante.setValue(row.validadeHidrante);
    this.formHidrante.controls.numeroPatrimonio.setValue(row.numeroPatrimonio);
    this.formHidrante.controls.ultimoTeste.setValue(row.ultimoTeste);
    this.formHidrante.controls.statusAtividade.setValue(row.statusAtividade);
    this.formExtintor.controls.validadeExtintor.setValue(row.validadeExtintor);
    this.formExtintor.controls.modeloExtintor.setValue(row.modeloExtintor);
    this.formExtintor.controls.seloInmetro.setValue(row.seloInmetro);
    this.formExtintor.controls.pesoExtintor.setValue(row.pesoExtintor);
    this.formExtintor.controls.anoExpecao.setValue(row.anoExpecao);
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
