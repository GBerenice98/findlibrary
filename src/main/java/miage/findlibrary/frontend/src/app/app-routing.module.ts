import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ShowGraphComponent } from './show-graph/show-graph.component';
import { HistoriqueRechercheComponent } from './historique-recherche/historique-recherche.component';
import { AProposComponent } from './apropos/apropos.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'graphes', component: ShowGraphComponent },
  { path: 'historique', component: HistoriqueRechercheComponent },
  { path: 'apropos', component: AProposComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
