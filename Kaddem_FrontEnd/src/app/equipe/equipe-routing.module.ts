import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';




import{ListEquipeComponent} from "./list-equipe/list-equipe.component"
import {UpdateDepartComponent} from "../gestion-departement/update-depart/update-depart.component";
import {UpdateEquipeComponent} from "./update-equipe/update-equipe.component";


const routes: Routes = [
  {path:"listequipe",component: ListEquipeComponent},
  {path: 'update/:idEquipe', component:UpdateEquipeComponent}



];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EquipeRoutingModule { }
