import { Injectable } from '@angular/core';
import { Departement } from './Models/Departement';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
@Injectable({
  providedIn: 'root'
})
export class ServiceDepartService {
  urlApi = 'http://localhost:8089/kaddem/departement/retrieve-all-departements';
  urlDel='http://localhost:8089/kaddem/departement/remove-departement/'
  urlAdd='http://localhost:8089/kaddem/departement/add-departement'
  urlGetId='http://localhost:8089/kaddem/departement/retrieve-departement/'
  urlUpdate='http://localhost:8089/kaddem/departement/update-departement'
  Departement=[];
  constructor(private http: HttpClient) { }



  getData():Observable<Departement[]> {
    return this.http.get<Departement[]>(this.urlApi);
}

delete(id:number){

  return  this.http.delete(this.urlDel+id)
      ;

}

AddDepart(Departement: Departement):Observable<Departement>{
 return this.http.post<Departement>(this.urlAdd,Departement)
}

  UpdateDepart(idDepart: number, d: Departement){

 return this.http.put<Departement>(this.urlUpdate,d);

}
getDepartById(id:Number){
  return this.http.get<Departement>(this.urlGetId+id);
}
}
