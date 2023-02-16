package ajc.formation.alten.finalRest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ReseauException extends RuntimeException{

    public ReseauException(String exceptionMessage) {
        super(exceptionMessage);
    }
    
}
