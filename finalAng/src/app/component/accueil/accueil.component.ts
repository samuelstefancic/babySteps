import { Account } from './../../model/account';
import { Router, ActivatedRoute } from '@angular/router';
import { AccountService } from './../../services/account.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-accueil',
  templateUrl: './accueil.component.html',
  styleUrls: ['./accueil.component.css'],
})
export class AccueilComponent implements OnInit {
  login = '';
  password = '';
  showError = false;
  showMessage = false;

  constructor(
    private acService: AccountService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {
    this.acService.logout();
  }

  ngOnInit(): void {
    this.showMessage = false;
    this.logout;
    //this.acService.checkLoginExist(this.login);
  }

  public logout() {
    this.acService.logout();
  }

  check() {
    this.acService.authentification(this.login, this.password).subscribe({
      next: (compte: Account) => {
        this.showError = false;
        localStorage.setItem(
          'tokenId',
          'Basic ' + window.btoa(this.login + ':' + this.password)
        );
        localStorage.setItem('compte', JSON.stringify(compte));
        this.router.navigateByUrl('/typereseau');
      },
      error: () => {
        this.showError = true;
      },
    });
  }
}
