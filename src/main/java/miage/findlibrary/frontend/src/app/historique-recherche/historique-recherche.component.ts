import { Component, OnInit } from '@angular/core';
import { ChartOptions, ChartType, ChartDataSets } from 'chart.js';
import { Label } from 'ng2-charts';
import { BiblioService } from '../services/biblio.service';

@Component({
  selector: 'app-historique-recherche',
  templateUrl: './historique-recherche.component.html',
  styleUrls: ['./historique-recherche.component.scss']
})
export class HistoriqueRechercheComponent implements OnInit {

  barChartOptions: ChartOptions = {
    responsive: true,
  };
  barChartType: ChartType = 'bar';
  barChartLegend = true;

  barChartLabels: Label[] = [];  
  barChartPlugins = [];
  barChartData: ChartDataSets[] = [];

  constructor(private biblioService : BiblioService){}

  ngOnInit()
  {
    let labels: string [] = [];
    let values: number [] = [];
    this.biblioService.getAllRecherches().subscribe(data => {
      console.log(" recherches : ", data);
      data.forEach( r => {
        labels.push(r.name);
        values.push(r.nb);
      })
      console.log("labels : ", labels);
      console.log(" values : ", values);
      this.barChartLabels=labels;
      this.barChartData = [
        { data:values, label: 'Bibliothèques sources recherchées' }
      ];
    })
    
  }

}
