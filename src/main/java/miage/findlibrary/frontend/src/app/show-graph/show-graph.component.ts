import { Component, OnInit } from '@angular/core';
import { BiblioService } from '../services/biblio.service';
import { Graphe } from '../models/graphe';

@Component({
  selector: 'app-show-graph',
  templateUrl: './show-graph.component.html',
  styleUrls: ['./show-graph.component.scss']
})
export class ShowGraphComponent implements OnInit {

  title = 'Les graphes de migrations disponibles';
  gridColumns = 3;
  lesGraphes: Array<Graphe>=[];
  constructor(private biblioService: BiblioService) { }

  ngOnInit(): void {
    
    this.biblioService.getAllGraphes().subscribe(data => {
      data.forEach(g=> {
        this.lesGraphes.push(g)
      })
    })
  }

  toggleGridColumns() {
    this.gridColumns = this.gridColumns === 3 ? 4 : 3;
  }

}
