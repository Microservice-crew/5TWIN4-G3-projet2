import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { DetailEquipe } from '../models/DetailEquipe';
import { Equipe } from '../models/Equipe';
import { environment } from 'src/environments/environment';


@Injectable({
  providedIn: 'root'
})
export class EquipeServicesService {

  public url= environment.defaultUrl+'/kaddem/equipe'



  constructor(private http :HttpClient) { }



postEquipe(data : any){
  return this.http.post<any>(`${this.url}/add-equipe`,data);

}



getEquipe(){
  return this.http.get<any>(`${this.url}/retrieve-all-equipes`);

}





getEquipeById(idequipe:any){
  return this.http.get<any>(`${this.url}/retrieve-equipe/${idequipe}`);

}





updateEquipe(idDepart: number ,data:any){

return this.http.put<any>(`${this.url}/update-equipe`,data)
}


deleteEquipe(id:number){
  return this.http.delete<any>(`${this.url}/remove-equipe/${id}`)
}





addDetailsToEquipe(details:any,idEquipe:number) {

  return this.http.put(`${this.url}/addDetails/${idEquipe}`,details)
}

}


