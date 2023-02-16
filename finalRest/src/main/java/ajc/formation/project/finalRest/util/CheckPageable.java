package ajc.formation.alten.finalRest.util;

import org.springframework.data.domain.Pageable;

import ajc.formation.alten.finalRest.exception.PageableException;

public class CheckPageable {
    
    public static void checkPageableIsNotNull(Pageable pageable) {
        if (pageable == null) {
            throw new PageableException();
        }
    }
}
