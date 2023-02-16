export class Account {
  public get accountRole(): string | undefined {
    return this._accountRole;
  }
  public set accountRole(value: string | undefined) {
    this._accountRole = value;
  }
  public get password(): string | undefined {
    return this._password;
  }
  public set password(value: string | undefined) {
    this._password = value;
  }
  public get login(): string | undefined {
    return this._login;
  }
  public set login(value: string | undefined) {
    this._login = value;
  }
  public get idAccount(): number | undefined {
    return this._idAccount;
  }
  public set idAccount(value: number | undefined) {
    this._idAccount = value;
  }
  constructor(
    private _idAccount?: number,
    private _login?: string,
    private _password?: string,
    private _accountRole?: string
  ) {}
}
