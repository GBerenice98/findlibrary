import { Component, OnInit } from '@angular/core';
import { BiblioService } from '../services/biblio.service';
import { Sommet } from '../models/sommet';
import { InfoModalComponent } from '../info-modal/info-modal.component';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Recherche } from '../models/recherche';
import { Graphe } from '../models/graphe';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  source : string;
  selectedCategorie : number = 0;
  showResults : boolean = false;
  libraryCibles: Array<Sommet> =[];
  lesGraphes:Array<Graphe> = [];

  constructor(private biblioService : BiblioService,private modalService: NgbModal,) {
    this.source="";
  }

  ngOnInit(): void {

    this.biblioService.getAllGraphes().subscribe(data => {
      console.log("data : ", data);
      data.forEach(g=> {
        this.lesGraphes.push(g)
      })
      console.log("lesGraphes : ", this.lesGraphes)
    })
  }

  searchLibrary()
  {
    if(this.selectedCategorie==0)
      this.openValidationModal("Merci de sélectionnez une catégorie. Pensez à regarder dans les graphes de migrations disponibles en cas de doute.");
    else{
      this.biblioService.libraryIsExist(this.selectedCategorie,this.source).subscribe(isExist => {
        console.log("exist ? : ", isExist)
        console.log("nom categorie : ",this.selectedCategorie)

        let recherche : Recherche=new Recherche();
        recherche.name=this.source;
        recherche.nb=1;
        this.biblioService.createRecherche(recherche).subscribe(r => { console.log("Recherche : ", r); })

        if(isExist) {
          let cibles: Array<Sommet>=[];
          this.biblioService.findLibraryCandidates(this.source).subscribe(data =>
          {
            if(data.length !=0) this.showResults=true;
            else this.openValidationModal("Désolé ! Nous n'avons pas trouvé de bibliothèques cibles pour cette bibliothèque.");
            data.forEach(s => {
              cibles.push(s);
            })
          })
          this.libraryCibles=cibles;
        }else this.openValidationModal("Nous n'avons pas trouvé cette bibliothèque dans notre base de données. Merci de vérifier votre syntaxe et la catégorie sélectionnée dans l'onglet 'Graphe' .");
      })
    }
  }

  public openValidationModal(message:string) : void {
    const modalRef = this.modalService.open(InfoModalComponent);
    modalRef.componentInstance.message = message;
  }

}
