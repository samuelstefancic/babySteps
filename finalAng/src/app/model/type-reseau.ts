import { Reseau } from './reseau';

export class TypeReseau {
  public get reseau(): Reseau | undefined {
    return this._reseau;
  }
  public set reseau(value: Reseau | undefined) {
    this._reseau = value;
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
  public get libelle(): string | undefined {
    return this._libelle;
  }
  public set libelle(value: string | undefined) {
    this._libelle = value;
  }
  public get idTypeReseau(): number | undefined {
    return this._idTypeReseau;
  }
  public set idTypeReseau(value: number | undefined) {
    this._idTypeReseau = value;
  }
  constructor(
    private _idTypeReseau?: number,
    private _libelle?: string,
    private _dateDerniereModification?: Date,
    private _rejet?: number,
    private _reseau?: Reseau
  ) {}
}
