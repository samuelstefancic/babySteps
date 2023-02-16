import { TypeReseauService } from './../../services/type-reseau.service';
import { TypeReseau } from './../../model/type-reseau';
import {
  AbstractControl,
  AsyncValidatorFn,
  FormGroup,
  ValidationErrors,
  ValidatorFn,
} from '@angular/forms';
import { map, Observable } from 'rxjs';
export class TypereseauValidator {
  typereseau!: TypeReseau;

  public static checkIdExist(
    typereseauSer: TypeReseauService
  ): AsyncValidatorFn {
    return (control: AbstractControl): Observable<ValidationErrors | null> => {
      return typereseauSer.checkIdExist(control.value).pipe(
        map((resultat: boolean) => {
          return resultat ? { idexist: true } : null;
        })
      );
    };
  }
}
