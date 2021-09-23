import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TelaLoginComponent } from './tela-login/tela-login.component';
import { TelaHomeComponent } from './tela-home/tela-home.component';
import { ComponenteMenuComponent } from './componente-menu/componente-menu.component';
import { TelaCadastroComponent } from './tela-cadastro/tela-cadastro.component';
import { TelaRelatoriosComponent } from './tela-relatorios/tela-relatorios.component';

@NgModule({
  declarations: [
    AppComponent,
    TelaLoginComponent,
    TelaHomeComponent,
    ComponenteMenuComponent,
    TelaCadastroComponent,
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
