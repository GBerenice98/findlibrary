import { Component, OnInit } from '@angular/core';
import { BiblioService } from '../services/biblio.service';
import { Sommet } from '../models/sommet';
import { InfoModalComponent } from '../info-modal/info-modal.component';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  source : string;
  showResults : boolean = false;
  libraryCibles: Array<Sommet> =[];
  constructor(private biblioService : BiblioService,private modalService: NgbModal,) {
    this.source="";
  }

  ngOnInit(): void {
  }

  searchLibrary()
  {
    let sourceExist=false;
    this.biblioService.libraryIsExist(this.source).subscribe(data => {
      console.log("exist ? : ", data)
      sourceExist=data;

      if(data)
      {
        let cibles: Array<Sommet>=[];
        this.biblioService.findLibraryCandidates(this.source).subscribe(data =>
          {      
            if(data.length !=0) this.showResults=true;
            data.forEach(s => {
              cibles.push(s);
            })
          })
          this.libraryCibles=cibles;
      }   
      else this.openValidationModal("Désolé ! Nous n'avons pas trouvé cette bibliothèque dans notre base de données."); 
    })
    
   // console.log(" source : ", sourceExist)
    

    
  }

  public openValidationModal(message:string) : void {
    const modalRef = this.modalService.open(InfoModalComponent);
    modalRef.componentInstance.message = message;
  }

}
