import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Sommet } from '../models/sommet';
import { Categorie } from '../models/categorie';

@Injectable({
  providedIn: 'root'
})
export class BiblioService {
  public url =environment.api_url;
  constructor(private http : HttpClient) {}


  public getAllCategories() : Observable<Array<Categorie>>{
    const routeQuery=this.url+"/getAllCategories/"+name;
    return this.http.get<Array<Categorie>>(routeQuery);
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
}
