package kg.megacom.salonmaster.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class BranchNotFound extends RuntimeException {
    public BranchNotFound(String message) {
        super(message);
    }
}
