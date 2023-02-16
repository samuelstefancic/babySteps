export class PPDistribution {
  public get mail(): string {
    return this._mail;
  }
  public set mail(value: string) {
    this._mail = value;
  }
  public get telephone2(): string {
    return this._telephone2;
  }
  public set telephone2(value: string) {
    this._telephone2 = value;
  }
  public get telephone1(): string {
    return this._telephone1;
  }
  public set telephone1(value: string) {
    this._telephone1 = value;
  }
  public get fax(): string {
    return this._fax;
  }
  public set fax(value: string) {
    this._fax = value;
  }
  public get dateDernierModification(): Date {
    return this._dateDernierModification;
  }
  public set dateDernierModification(value: Date) {
    this._dateDernierModification = value;
  }
  public get rejet(): number {
    return this._rejet;
  }
  public set rejet(value: number) {
    this._rejet = value;
  }
  public get prenom(): string {
    return this._prenom;
  }
  public set prenom(value: string) {
    this._prenom = value;
  }
  public get nom(): string {
    return this._nom;
  }
  public set nom(value: string) {
    this._nom = value;
  }
  public get civilite(): string {
    return this._civilite;
  }
  public set civilite(value: string) {
    this._civilite = value;
  }
  public get IdPPDistribution(): number {
    return this._IdPPDistribution;
  }
  public set IdPPDistribution(value: number) {
    this._IdPPDistribution = value;
  }
  constructor(
    private _IdPPDistribution: number,
    private _civilite: string,
    private _nom: string,
    private _prenom: string,
    private _telephone1: string,
    private _telephone2: string,
    private _mail: string,
    private _fax: string,
    private _dateDernierModification: Date,
    private _rejet: number
  ) {}
}
