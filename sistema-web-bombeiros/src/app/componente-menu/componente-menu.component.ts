import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-componente-menu',
  templateUrl: './componente-menu.component.html',
  styleUrls: ['./componente-menu.component.scss']
})
export class ComponenteMenuComponent implements OnInit {
  classeMobile: String = "none";
  classeDesktop: String = "";
  classeBotao: String = "";
  windowWidth = window.innerWidth;

  constructor() { }

  ngOnInit() {
    if(this.windowWidth <= 540) {
      this.classeBotao = "absolute";
      this.classeDesktop = "none";
    } else {
      this.classeBotao = "none";
      this.classeDesktop = "initial";
    }
  }

  abrirMenu() {

  }

}
