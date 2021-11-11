import { Component, OnInit } from '@angular/core';
import { PageEvent } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { EdificacoesService } from '../services/edificacoes.service';
import { ExtintoresService } from '../services/extintores.service';
import { HidrantesService } from '../services/hidrantes.service';
import { MangueirasService } from '../services/mangueiras.service';
import { ValvulasService } from '../services/valvulas.service';

@Component({
  selector: 'app-tela-relatorios',
  templateUrl: './tela-relatorios.component.html',
  styleUrls: ['./tela-relatorios.component.scss']
})
export class TelaRelatoriosComponent implements OnInit {

  hide = true;
  dados: any;
  edificacoes: any;
  objetos: any;
  dataSource = new MatTableDataSource([]);
  displayedColumns: string[] = [
    'nome',
    'endereco',
    'telefone1',
    'tipoEdificacao',
    'validadeMangueira',
    'validadeExtintor',
    'validadeValvula',
    'validadeHidrante',
  ];

  constructor(
    private edificacoesService: EdificacoesService,
    private extintoresService: ExtintoresService,
    private hidrantesService: HidrantesService,
    private mangueirasService: MangueirasService,
    private valvulasService: ValvulasService,
  ) { }

  ngOnInit(): void {
    this.getDados();
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
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

  carregarNaTela(row: any) {

  }

  async getDados() {
    this.edificacoes = await this.edificacoesService.list()
    const extintores = await this.extintoresService.list()
    const mangueiras = await this.mangueirasService.list()
    const hidrantes = await this.hidrantesService.list()
    const valvulas = await this.valvulasService.list()

    for (let i = 0; i < this.edificacoes.length; i++) {
      this.valvulasService.findByEdificacao(this.edificacoes[i].id)
      this.extintoresService.findByEdificacao(this.edificacoes[i].id)
      this.mangueirasService.findByEdificacao(this.edificacoes[i].id)
      this.hidrantesService.findByEdificacao(this.edificacoes[i].id)
    }

    this.dataSource = new MatTableDataSource(this.edificacoes)
    console.log(extintores);
    console.log(mangueiras);
    console.log(hidrantes);
    console.log(valvulas);
    console.log(this.edificacoes);
  }

}
