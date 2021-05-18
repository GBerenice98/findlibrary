import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Sommet } from '../models/sommet';
import { Graphe } from '../models/graphe';
import { Recherche } from '../models/recherche';

@Injectable({
  providedIn: 'root'
})
export class BiblioService {
  public url =environment.api_url;
  constructor(private http : HttpClient) {}


  public getAllGraphes() : Observable<Array<Graphe>>{
    const routeQuery=this.url+"/getAllGraphes/"+name;
    return this.http.get<Array<Graphe>>(routeQuery);
  }

  public getAllSommetsOfGraphe(id : number) : Observable<Array<Sommet>>{
    const routeQuery=this.url+"/getAllSommetOfGraphe/"+id;
    return this.http.get<Array<Sommet>>(routeQuery);
  }

  public libraryIsExist(name : string): Observable<boolean>
  {
    const routeQuery=this.url+"/isExist/"+name;
    return this.http.get<boolean>(routeQuery);
  }

  public findLibraryCandidates(name : string) : Observable<Array<Sommet>> {   
    const routeQuery=this.url+"/getCibles/"+name;
    return this.http.get<Array<Sommet>>(routeQuery);
  }

  public createRecherche(recherche : Recherche): Observable<Array<Recherche>>{
    const routeQuery=this.url+"/createRecherche";
    return this.http.post<Array<Recherche>>(routeQuery, recherche);
  }

  public getAllRecherches() : Observable<Array<Recherche>>{
    const routeQuery=this.url+"/getAllRecherches";
    return this.http.get<Array<Recherche>>(routeQuery);
  }


}
