import { Component, OnInit } from '@angular/core';
import {FormBuilder} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {Equipe} from "../models/Equipe";
import {EquipeServicesService} from "../services/equipe-services.service";

@Component({
  selector: 'app-update-equipe',
  templateUrl: './update-equipe.component.html',
  styleUrls: ['./update-equipe.component.css']
})
export class UpdateEquipeComponent implements OnInit {
  myId=0;
  myEquipe!:Equipe;
  reactiveForm=this.fb.group(
    {
      idEquipe:[''],
      nomEquipe:[''],
      niveau:[''],


    }
  );

  constructor(private fb:FormBuilder,private actR: ActivatedRoute,private serviceEquipe:EquipeServicesService,private R:Router) { }

  ngOnInit(): void {
    this.serviceEquipe.getEquipeById(this.actR.snapshot.params["idEquipe"]).subscribe(data=>{
      this.myEquipe=data;


      this.reactiveForm.patchValue({idEquipe: this.myEquipe.idEquipe ,nomEquipe:this.myEquipe.nomEquipe,niveau:this.myEquipe.niveau});
      console.log(this.myEquipe.nomEquipe)

    });
  }


  get idEquipe(){
    return this.reactiveForm.get('idEquipe')
  }
  get nomEquipe(){
    return this.reactiveForm.get('nomEquipe');

  }

  update(){

    this.serviceEquipe.updateEquipe(this.myEquipe.idEquipe,this.reactiveForm.value).subscribe(data=>{

        this.R.navigate(['/equipe/listequipe']);
      }
    )


  }




}
