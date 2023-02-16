package ajc.formation.alten.finalRest.util;

import ajc.formation.alten.finalRest.exception.IdException;

public class CheckId {
    
	public static void CheckIdIsNotNull(Long id) {
		if (id == null) {
            throw new IdException();
        }		
	}
}
