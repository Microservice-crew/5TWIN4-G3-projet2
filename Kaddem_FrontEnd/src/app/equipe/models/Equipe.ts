export enum Niveau {
  JUNIOR = 'JUNIOR',
  SENIOR = 'SENIOR',
  EXPERT = 'EXPERT',
}

export class Equipe {
  idEquipe!: number;
  nomEquipe!: string;
  niveau!: Niveau;
}
