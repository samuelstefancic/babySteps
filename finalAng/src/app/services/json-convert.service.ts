import { PPDistribution } from './../model/ppdistribution';
import { TypeReseau } from './../model/type-reseau';
import { Injectable } from '@angular/core';
import { Reseau } from '../model/reseau';

@Injectable({
  providedIn: 'root',
})
export class JsonConvertService {
  constructor() {}
  public typeReseauToJson(typeReseau: TypeReseau): any {
    let typeReseauJson = {
      libelle: typeReseau.libelle,
      dateDerniereModification: typeReseau.dateDerniereModification,
      rejet: typeReseau.rejet,
    };
    if (typeReseau.idTypeReseau) {
      Object.assign(typeReseauJson, { idTypeReseau: typeReseau.idTypeReseau });
    }
    // if (typeReseau.reseau) {             !!!!! ne touche pas
    //   Object.assign(typeReseauJson, {
    //     reseau: this.reseauTOJson(typeReseau.reseau),
    //   });
    // }
    return typeReseauJson;
  }
  public reseauTOJson(reseau: Reseau): any {
    let reseauJson = {
      libelle: reseau.libelle,
      codeExterne: reseau.codeExterne,
      dateDebut: reseau.dateDebut,
      dateFin: reseau.dateFin,
      dateDernierModification: reseau.dateDerniereModification,
      rejet: reseau.rejet,
    };
    if (reseau.idReseau) {
      Object.assign(reseauJson, { idReseau: reseau.idReseau });
    }
    if (reseau.idCodeInterneReseau) {
      Object.assign(reseauJson, {
        idCodeInterneReseau: reseau.idCodeInterneReseau,
      });
      if (reseau.responsable) {
        Object.assign(reseauJson, {
          responsable: this.ppdisttibutionTOJson(reseau.responsable),
        });
      }
    }

    return reseauJson;
  }
  public ppdisttibutionTOJson(ppdistribution: PPDistribution) {
    let ppdistributionJson = {
      civilite: ppdistribution.civilite,
      nom: ppdistribution.nom,
      prenom: ppdistribution.prenom,
      telephone1: ppdistribution.telephone1,
      telephone2: ppdistribution.telephone2,
      mail: ppdistribution.mail,
      fax: ppdistribution.fax,
      dateDernierModification: ppdistribution.dateDernierModification,
      rejet: ppdistribution.rejet,
    };
    if (ppdistribution.IdPPDistribution) {
      Object.assign(ppdistributionJson, {
        IdPPDistribution: ppdistribution.IdPPDistribution,
      });
    }
  }
}
