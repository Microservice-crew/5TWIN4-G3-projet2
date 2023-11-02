import { Component, Inject, OnInit } from '@angular/core';
import { FormGroup,FormBuilder,Validators } from '@angular/forms';
import { EquipeServicesService } from '../services/equipe-services.service';
import { MatDialogRef,MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Equipe } from '../models/Equipe';
import { HttpService } from '../services/http.service';


@Component({
  selector: 'app-dialog-equipe',
  templateUrl: './dialog-equipe.component.html',
  styleUrls: ['./dialog-equipe.component.css']
})
export class DialogEquipeComponent implements OnInit {

  equipenew!: Equipe;


   ListNveau =["JUNIOR","SENIOR","EXPERT"]

   equipeForm !: FormGroup
   actionButton:string="Ajouter"
  updatedEquipe!: Equipe;

  constructor(private formBuilder : FormBuilder , private equipeService:EquipeServicesService,
              @Inject(MAT_DIALOG_DATA) public editdata:any,
              private matdialoRef  :MatDialogRef<DialogEquipeComponent>,private http: HttpService) { }



    taswira! : string;

  ngOnInit(): void {


    this.equipenew =  new Equipe();





    this.equipeForm=this.formBuilder.group({

      nomEquipe :['',[Validators.required,
                      Validators.pattern('[a-zA-Z ]*'),
                      Validators.minLength(3)] ],

      niveau :['',Validators.required ],



    })


    console.log(this.editdata)

    if(this.editdata){
      this.actionButton="Modifier"
      this.equipeForm.controls['nomEquipe'].setValue(this.editdata.nomEquipe)
      this.equipeForm.controls['niveau'].setValue(this.editdata.niveau)
    }


  }





  addEquipe() {
    console.log(this.equipeForm.value);
        this.equipeService.postEquipe(this.equipeForm.value)
          .subscribe({
            next: (res) => {
              alert("Team added successfully");
              this.matdialoRef.close("add");
            }
          });

  }







}

