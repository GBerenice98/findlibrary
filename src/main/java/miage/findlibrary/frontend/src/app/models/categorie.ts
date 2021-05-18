import { Sommet } from './sommet';

export class Categorie {
    name?:string;
    idCategorie?:number;
    listSommets : Array<Sommet> =[];
}
