import { PPDistribution } from './ppdistribution';
export class Reseau {
  public get responsable(): PPDistribution | undefined {
    return this._responsable;
  }
  public set responsable(value: PPDistribution | undefined) {
    this._responsable = value;
  }
  public get rejet(): number | undefined {
    return this._rejet;
  }
  public set rejet(value: number | undefined) {
    this._rejet = value;
  }
  public get dateDerniereModification(): Date | undefined {
    return this._dateDerniereModification;
  }
  public set dateDerniereModification(value: Date | undefined) {
    this._dateDerniereModification = value;
  }
  public get dateFin(): Date | undefined {
    return this._dateFin;
  }
  public set dateFin(value: Date | undefined) {
    this._dateFin = value;
  }
  public get dateDebut(): Date | undefined {
    return this._dateDebut;
  }
  public set dateDebut(value: Date | undefined) {
    this._dateDebut = value;
  }
  public get libelle(): string | undefined {
    return this._libelle;
  }
  public set libelle(value: string | undefined) {
    this._libelle = value;
  }
  public get codeExterne(): number | undefined {
    return this._codeExterne;
  }
  public set codeExterne(value: number | undefined) {
    this._codeExterne = value;
  }
  public get idCodeInterneReseau(): number | undefined {
    return this._idCodeInterneReseau;
  }
  public set idCodeInterneReseau(value: number | undefined) {
    this._idCodeInterneReseau = value;
  }
  public get idReseau(): number | undefined {
    return this._idReseau;
  }
  public set idReseau(value: number | undefined) {
    this._idReseau = value;
  }
  constructor(
    private _idReseau?: number,
    private _idCodeInterneReseau?: number,
    private _codeExterne?: number,
    private _libelle?: string,
    private _dateDebut?: Date,
    private _dateFin?: Date,
    private _dateDerniereModification?: Date,
    private _rejet?: number,
    private _responsable?: PPDistribution
  ) {}
}
