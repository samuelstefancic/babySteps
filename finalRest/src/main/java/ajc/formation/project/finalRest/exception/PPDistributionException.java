package ajc.formation.alten.finalRest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class PPDistributionException extends RuntimeException {
    
    public PPDistributionException(String exceptionMessage) {
        super(exceptionMessage);
    }
}

