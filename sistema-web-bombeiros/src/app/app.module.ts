import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TelaCadastroComponent } from './tela-cadastro/tela-cadastro.component';
import { TelaLoginComponent } from './tela-login/tela-login.component';
import { TelaHomeComponent } from './tela-home/tela-home.component';
import { ComponenteMenuComponent } from './componente-menu/componente-menu.component';
import { TelaRelatoriosComponent } from './tela-relatorios/tela-relatorios.component';

@NgModule({
  declarations: [
    AppComponent,
    TelaCadastroComponent,
    TelaLoginComponent,
    TelaHomeComponent,
    ComponenteMenuComponent,
    TelaRelatoriosComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
