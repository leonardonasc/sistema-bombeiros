import { Component, OnInit } from '@angular/core';
import { PageEvent } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-tela-relatorios',
  templateUrl: './tela-relatorios.component.html',
  styleUrls: ['./tela-relatorios.component.scss']
})
export class TelaRelatoriosComponent implements OnInit {

  hide = true;
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

  constructor() { }

  ngOnInit(): void {
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

}
